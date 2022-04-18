package dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Service.LoginService;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.AuthenticationResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;

public class LoginEndPoints {

    private final LoginService loginService;

    public LoginEndPoints(LoginService loginService) {
        this.loginService = loginService;
    }

    public AuthenticationResponse loginUser(LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }


}
