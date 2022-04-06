package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Table(name = "token")
public class VerificationTokenEntity {
    @Id
    private Long id;

    private String token;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "expirydate")
    private Instant expiryDate;

    public VerificationTokenEntity(){}

    public VerificationTokenEntity(Long id, String token, Long userId, Instant expiryDate) {
        this.id = id;
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }

    public VerificationTokenEntity(String token, Long userId, Instant expiryDate) {
        this.token = token;
        this.userId = userId;
        this.expiryDate = expiryDate;
    }
}
