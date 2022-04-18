package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ManagerAuthenticator /*implements InitializingBean */{

    private AuthenticationManager authenticationManager;
    //private final ApplicationContext applicationContext;

    public Authentication authenticateByEmailAndPassword(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword());
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    public void setAuthenticationToSecurityContext(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        authenticationManager = applicationContext.getBean(AuthenticationManager.class);
//    }
}
