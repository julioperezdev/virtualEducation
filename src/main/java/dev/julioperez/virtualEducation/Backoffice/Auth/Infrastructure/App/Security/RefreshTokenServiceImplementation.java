package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security;


import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//@Transactional
//public class RefreshTokenServiceImplementation implements RefreshTokenService {
//
//    private final RefreshTokenDao refreshTokenDao;
//
//    @Override
//    public RefreshToken generateRefreshToken() {
//        RefreshToken refreshToken = new RefreshToken();
//        refreshToken.setToken(UUID.randomUUID().toString());
//        refreshToken.setCreateDate(Date.from(Instant.now()));
//
//        return refreshTokenDao.saveRefreshToken(refreshToken.getToken(), refreshToken.getCreateDate());
//    }
//
//    @Override
//    public void validateRefreshToken(String token) {
//        refreshTokenDao.getRefreshTokenByToken(token)
//                .orElseThrow(InvalidRefreshTokenException::new);
//    }
//
//    @Override
//    public void deleteRefreshToken(String token) {
//        refreshTokenDao.deleteRefreshTokenByToken(token);
//    }
//}