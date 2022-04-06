package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository.SignupAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.VerificationToken;

public class SignupServiceImplementation implements SignupService{

    private final SignupAdapterRepository signupAdapterRepository;

    public SignupServiceImplementation(SignupAdapterRepository signupAdapterRepository) {
        this.signupAdapterRepository = signupAdapterRepository;
    }

    @Override
    public void fetchUserAndEnable(VerificationToken verificationToken) {

    }

    @Override
    public void signup(RegisterRequest registerRequest) {

    }
}
