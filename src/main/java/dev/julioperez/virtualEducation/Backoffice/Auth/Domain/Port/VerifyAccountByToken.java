package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface VerifyAccountByToken {
    void verifyAccount(String token);
}
