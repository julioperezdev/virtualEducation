package dev.julioperez.virtualEducation.Shared.Application.encodeString.Service;

import dev.julioperez.virtualEducation.Shared.Application.encodeString.Adapter.StringEncoderAdapter;

public class StringEncoderServiceImplementation implements StringEncoderService{

    private final StringEncoderAdapter stringEncoderAdapter;

    public StringEncoderServiceImplementation(StringEncoderAdapter stringEncoderAdapter) {
        this.stringEncoderAdapter = stringEncoderAdapter;
    }

    public String encodeString(String stringToEncode){
        return stringEncoderAdapter.encodeString(stringToEncode);
    }
}
