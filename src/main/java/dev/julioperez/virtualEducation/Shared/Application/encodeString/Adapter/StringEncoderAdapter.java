package dev.julioperez.virtualEducation.Shared.Application.encodeString.Adapter;

import dev.julioperez.virtualEducation.Shared.Infrastructure.Gateway.SpringFrameworkStringEncoder;

public class StringEncoderAdapter {

    private final SpringFrameworkStringEncoder springFrameworkStringEncoder;

    public StringEncoderAdapter(SpringFrameworkStringEncoder springFrameworkStringEncoder) {
        this.springFrameworkStringEncoder = springFrameworkStringEncoder;
    }

    public String encodeString(String stringToEncode){
        return springFrameworkStringEncoder.encodeString(stringToEncode);
    }
}
