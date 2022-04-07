package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery.SignupEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterRequest;
import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.RegisterResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class SpringSignupController {

    private final SignupEndPoints signupEndPoints;

    public SpringSignupController(SignupEndPoints signupEndPoints) {
        this.signupEndPoints = signupEndPoints;
    }

    @PostMapping
    public void signupUser(RegisterRequest registerRequest){
        RegisterResponse registerResponse = signupEndPoints.signupUser(registerRequest);
        //return
    }

    @GetMapping("/{token}")
    public void verificationToken(@PathVariable String token){
        signupEndPoints.verifyAccountByToken(token);
        //return
    }
}
