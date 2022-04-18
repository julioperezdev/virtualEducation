package dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Service;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.LoginModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Adapter.LoginAdapterSecurity;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.refreshToken.Service.RefreshTokenService;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.AuthenticationResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;

public class LoginServiceImplementation implements LoginService{

    private final LoginAdapterSecurity loginAdapterSecurity;
    private final LoginModelMapper loginModelMapper;
    private final RefreshTokenService refreshTokenService;

    public LoginServiceImplementation(LoginAdapterSecurity loginAdapterSecurity, LoginModelMapper loginModelMapper, RefreshTokenService refreshTokenService) {
        this.loginAdapterSecurity = loginAdapterSecurity;
        this.loginModelMapper = loginModelMapper;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        String tokenGenerated = loginAdapterSecurity.generateTokenByLoginRequest(loginRequest);
        String refreshTokenGenerated = refreshTokenService.generateRefreshToken().getToken();
        return loginModelMapper.toAuthenticationResponse(
                tokenGenerated,
                loginRequest.getEmail(),
                refreshTokenGenerated);
    }
}
