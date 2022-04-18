package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.login.Delivery.LoginEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.AuthenticationResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;
import dev.julioperez.virtualEducation.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class SpringLoginController {

    private final LoginEndPoints loginEndPoints;

    @PostMapping
    public RestResponse<AuthenticationResponse> loginUser(@RequestBody LoginRequest loginRequest){
        AuthenticationResponse authenticationResponse = loginEndPoints.loginUser(loginRequest);
        return new RestResponse<>(HttpStatus.ACCEPTED, authenticationResponse);
    }
}
