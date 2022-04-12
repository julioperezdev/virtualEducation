package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.time.Instant;

public class VerificationToken {

    private Long id;
    private String token;
    private Long userId;
    private Instant expiryDate;

    /**
     * can exist two constructor with any argument and all argument least idUser
     */
    public VerificationToken(Long id, String token, Long userId, Instant expiryDate) {
        this.id = id;
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }

    public VerificationToken(String token, Long userId, Instant expiryDate) {
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }

    public VerificationToken(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }
}
