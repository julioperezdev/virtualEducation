package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service.SignupService;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterResponse;

public class SignupEndPoints {

    private final SignupService signupService;
    private final SignupModelMapper signupModelMapper;

    public SignupEndPoints(SignupService signupService, SignupModelMapper signupModelMapper) {
        this.signupService = signupService;
        this.signupModelMapper = signupModelMapper;
    }

    public RegisterResponse signupUser(RegisterResponse registerResponse){
        return null;
    }
}
