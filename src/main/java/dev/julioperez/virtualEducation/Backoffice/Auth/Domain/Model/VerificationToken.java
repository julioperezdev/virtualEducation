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
}
