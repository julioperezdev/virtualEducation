package dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Adapter;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security.JwtProvider;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security.ManagerAuthenticator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginAdapterSecurity {

    //private final ManagerAuthenticator managerAuthenticator;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public LoginAdapterSecurity(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        //this.managerAuthenticator = managerAuthenticator;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public String generateTokenByLoginRequest(LoginRequest loginRequest){
        Authentication authentication = this.authenticateWithManager(loginRequest);
        return jwtProvider.generateToken(authentication);
    }

    private Authentication authenticateWithManager(LoginRequest loginRequest){
        //Authentication authentication = managerAuthenticator.authenticateByEmailAndPassword(loginRequest);
        Authentication authentication = this.authenticateByEmailAndPassword(loginRequest);
        //managerAuthenticator.setAuthenticationToSecurityContext(authentication);
        this.setAuthenticationToSecurityContext(authentication);
        return authentication;
    }

    public Long getJwtExpirationInMillisToAuthenticationResponse(){
        return jwtProvider.getJwtExpirationInMillis();
    }

    public Authentication authenticateByEmailAndPassword(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword());
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    public void setAuthenticationToSecurityContext(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
