package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface DeleteRefreshTokenByToken {
    void deleteRefreshToken(String token);
}
