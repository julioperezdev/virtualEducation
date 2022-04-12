package dev.julioperez.virtualEducation.Announcement.Email.Application.Service;

import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.EmailRequest;
import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.NotificationEmail;

public interface MailSenderService {
    void sendMail(EmailRequest emailRequest);
}
