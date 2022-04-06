package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface RefreshTokenService extends GenerateRefreshToken, ValidateRefreshTokenByToken, DeleteRefreshTokenByToken{
}
