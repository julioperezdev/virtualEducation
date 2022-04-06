package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.time.Instant;

public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
    private String refreshToken;
    private Instant expireAt;

    public AuthenticationResponse(String authenticationToken, String username, String refreshToken, Instant expireAt) {
        this.authenticationToken = authenticationToken;
        this.username = username;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Instant getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Instant expireAt) {
        this.expireAt = expireAt;
    }
}
