package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery.SignupEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterResponse;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.VerifyTokenResponse;
import dev.julioperez.virtualEducation.Shared.Infrastructure.Delivery.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class SpringSignupController {

    private final SignupEndPoints signupEndPoints;

    public SpringSignupController(SignupEndPoints signupEndPoints) {
        this.signupEndPoints = signupEndPoints;
    }

    @PostMapping
    public RestResponse<RegisterResponse> signupUser(RegisterRequest registerRequest){
        RegisterResponse registerResponse = signupEndPoints.signupUser(registerRequest);
        return new RestResponse<>(HttpStatus.CREATED, registerResponse);
    }

    @GetMapping("/{token}")
    public RestResponse<VerifyTokenResponse> verificationToken(@PathVariable String token){
        VerifyTokenResponse verifyTokenResponse = signupEndPoints.verifyAccountByToken(token);
        return new RestResponse<>(HttpStatus.ACCEPTED, verifyTokenResponse);
    }
}
