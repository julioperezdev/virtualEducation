package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

public interface AuthService extends SignupByRegisterRequest, VerifyAccountByToken, FetchUserAndEnableByVerificationToken, LoginByLoginRequest{
}
