package dev.julioperez.virtualEducation.Backoffice.Auth.Application.refreshToken.Service;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.DeleteRefreshTokenByToken;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.GenerateRefreshToken;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.ValidateRefreshTokenByToken;

public interface RefreshTokenService extends
        GenerateRefreshToken,
        ValidateRefreshTokenByToken,
        DeleteRefreshTokenByToken {
}
