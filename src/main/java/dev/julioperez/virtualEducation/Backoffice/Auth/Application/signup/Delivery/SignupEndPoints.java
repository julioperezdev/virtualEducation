package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service.SignupService;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerifyTokenResponse;

public class SignupEndPoints {

    private final SignupService signupService;
    private final SignupModelMapper signupModelMapper;

    public SignupEndPoints(SignupService signupService, SignupModelMapper signupModelMapper) {
        this.signupService = signupService;
        this.signupModelMapper = signupModelMapper;
    }

    public RegisterResponse signupUser(RegisterRequest registerRequest){
        //todo: create exception for registerRequest
        if (registerRequest.validateFields()) throw new RuntimeException("registerRequest does not have requirements to follow the process");
        Boolean processedSignupResponse = signupService.signup(registerRequest);
        return signupModelMapper.processedSignupResponseToRegisterResponse(processedSignupResponse);
    }

    public VerifyTokenResponse verifyAccountByToken(String token){
        return signupService.verifyAccount(token);
    }
}
