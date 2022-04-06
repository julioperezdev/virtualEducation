package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RefreshToken;

public interface GenerateRefreshToken {
    RefreshToken generateRefreshToken();
}
