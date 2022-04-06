package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.FetchUserAndEnableByVerificationToken;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port.SignupByRegisterRequest;

public interface SignupService extends FetchUserAndEnableByVerificationToken, SignupByRegisterRequest {
}
