package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerifyTokenResponse;

public interface VerifyAccountByToken {
    VerifyTokenResponse verifyAccount(String token);
}
