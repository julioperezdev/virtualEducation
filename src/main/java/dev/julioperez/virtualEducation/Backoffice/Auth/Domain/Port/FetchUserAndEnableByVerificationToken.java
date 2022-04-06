package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface FetchUserAndEnableByVerificationToken {
    void fetchUserAndEnable(VerificationToken verificationToken);
}
