package dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RefreshToken;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model.RefreshTokenEntity;

public class RefreshTokenModelMapper {

    public RefreshToken toRefreshTokenModel(RefreshTokenEntity refreshTokenEntity){
        return new RefreshToken(
                refreshTokenEntity.getId(),
                refreshTokenEntity.getToken(),
                refreshTokenEntity.getCreatedDate());
    }

    public RefreshTokenEntity toRefreshEntity(RefreshToken refreshToken){
        return new RefreshTokenEntity(
                refreshToken.getToken(),
                refreshToken.getCreateDate());
    }
}
