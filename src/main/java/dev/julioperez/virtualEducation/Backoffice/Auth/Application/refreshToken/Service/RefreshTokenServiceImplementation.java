package dev.julioperez.virtualEducation.Backoffice.Auth.Application.refreshToken.Service;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.refreshToken.Adapter.RefreshTokenAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RefreshToken;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.UUID;

public class RefreshTokenServiceImplementation implements RefreshTokenService{

    private final RefreshTokenAdapterRepository refreshTokenAdapterRepository;

    public RefreshTokenServiceImplementation(RefreshTokenAdapterRepository refreshTokenAdapterRepository) {
        this.refreshTokenAdapterRepository = refreshTokenAdapterRepository;
    }

    @Override
    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken(
                UUID.randomUUID().toString(),
                Calendar.getInstance());
        return refreshTokenAdapterRepository.createRefreshToken(refreshToken);
    }

    @Override
    public void validateRefreshToken(String token) {

    }

    @Override
    public void deleteRefreshToken(String token) {

    }
}
