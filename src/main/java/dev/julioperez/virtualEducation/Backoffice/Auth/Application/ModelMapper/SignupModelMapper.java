package dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.User;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerificationToken;

import java.time.Instant;
import java.util.Date;

public class SignupModelMapper {

    public User registerRequestToUser(RegisterRequest registerRequest){
        return new User(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getEmail(),
                Date.from(Instant.now()),
                Boolean.FALSE,
                registerRequest.getIdRol());
    }

    public VerificationToken userToVerificationToken(User recordedUser, String token){
        return new VerificationToken(
                token,
                recordedUser.getUserId());
    }
}
