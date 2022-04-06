package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.AuthenticationResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;

public interface LoginByLoginRequest {
    AuthenticationResponse login(LoginRequest loginRequest);
}
