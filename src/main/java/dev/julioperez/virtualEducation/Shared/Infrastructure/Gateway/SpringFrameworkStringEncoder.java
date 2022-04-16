package dev.julioperez.virtualEducation.Shared.Infrastructure.Gateway;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class SpringFrameworkStringEncoder {

    private final PasswordEncoder passwordEncoder;

    public String encodeString(String stringToEncode){
        return passwordEncoder.encode(stringToEncode);
    }
}
