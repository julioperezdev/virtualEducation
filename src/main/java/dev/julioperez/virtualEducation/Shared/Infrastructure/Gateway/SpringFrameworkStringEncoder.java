package dev.julioperez.virtualEducation.Shared.Infrastructure.Gateway;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class SpringFrameworkStringEncoder {

    private final PasswordEncoder passwordEncoder;

    public SpringFrameworkStringEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public String encodeString(String stringToEncode){
        return passwordEncoder.encode(stringToEncode);
    }
}
