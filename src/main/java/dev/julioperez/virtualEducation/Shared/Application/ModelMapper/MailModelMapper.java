package dev.julioperez.virtualEducation.Shared.Application.ModelMapper;

import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.EmailRequest;

public class MailModelMapper {

    public EmailRequest toEmailRequest(String email, String token){
        return new EmailRequest(email, token);
    }
}
