package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service;

import dev.julioperez.virtualEducation.Announcement.Email.Application.Service.MailSenderService;
import dev.julioperez.virtualEducation.Announcement.Email.Domain.Exception.ErrorOccurredWhenSendingEmailException;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository.SignupAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.User;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerificationToken;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerifyTokenResponse;
import dev.julioperez.virtualEducation.Shared.Application.ModelMapper.MailModelMapper;
import dev.julioperez.virtualEducation.Shared.Application.encodeString.Service.StringEncoderService;

import java.util.UUID;

public class SignupServiceImplementation implements SignupService{

    private final SignupAdapterRepository signupAdapterRepository;
    private final StringEncoderService stringEncoderService;
    private final SignupModelMapper signupModelMapper;
    private final MailSenderService mailSenderService;
    private final MailModelMapper mailModelMapper;

    public SignupServiceImplementation(SignupAdapterRepository signupAdapterRepository, StringEncoderService stringEncoderService, SignupModelMapper signupModelMapper, MailSenderService mailSenderService, MailModelMapper mailModelMapper) {
        this.signupAdapterRepository = signupAdapterRepository;
        this.stringEncoderService = stringEncoderService;
        this.signupModelMapper = signupModelMapper;
        this.mailSenderService = mailSenderService;
        this.mailModelMapper = mailModelMapper;
    }

    @Override
    public Boolean signup(RegisterRequest registerRequest) throws ErrorOccurredWhenSendingEmailException {
        if(registerRequest.validateFields()) throw new RuntimeException();
        RegisterRequest registerWithPasswordEncoded = this.encodePasswordByRegisterRequest(registerRequest);
        User userToRecord = signupModelMapper.registerRequestToUser(registerWithPasswordEncoded);
        User recordedUser = signupAdapterRepository.createUser(userToRecord);
        String recordedValidationToken = this.generateVerificationToken(recordedUser);
        //todo: send email with token generated
        mailSenderService.sendMail(mailModelMapper.toEmailRequest(
                registerRequest.getEmail(),
                recordedValidationToken));
        return Boolean.TRUE;
    }

    private RegisterRequest encodePasswordByRegisterRequest(RegisterRequest registerRequest){
        registerRequest.setPassword(stringEncoderService.encodeString(registerRequest.getPassword()));
        return registerRequest;
    }

    private String generateVerificationToken(User recordedUser){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = signupModelMapper.userModelToVerificationToken(recordedUser, token);
        signupAdapterRepository.createToken(
                verificationToken.getToken(),
                verificationToken.getUserId());
        return token;
    }

    @Override
    public VerifyTokenResponse verifyAccount(String token) {
        VerificationToken verificationTokenByTokenFound = signupAdapterRepository
                .getVerificationTokenByToken(token);
        User userEnabled = signupAdapterRepository.updateStatusToEnableAUser(
                verificationTokenByTokenFound.getUserId());
        if(Boolean.FALSE == userEnabled.isEnable()) throw new RuntimeException();
        return signupModelMapper.processedVerifyByTokenResponseToVerifyTokenResponse(
                userEnabled.isEnable());
    }
}
