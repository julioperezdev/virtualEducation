package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface ValidateRefreshTokenByToken {
    void validateRefreshToken(String token);
}
