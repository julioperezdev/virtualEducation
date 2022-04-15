package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;

public interface SignupByRegisterRequest {
    Boolean signup(RegisterRequest registerRequest);
}
