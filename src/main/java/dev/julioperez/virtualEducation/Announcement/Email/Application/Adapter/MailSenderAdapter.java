package dev.julioperez.virtualEducation.Announcement.Email.Application.Adapter;

import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.MailSender;
import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.NotificationEmail;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;

public class MailSenderAdapter implements MailSender {

    private final SpringJavaMailer springJavaMailer;

    public MailSenderAdapter(SpringJavaMailer springJavaMailer) {
        this.springJavaMailer = springJavaMailer;
    }

    public void sendMail(NotificationEmail notificationEmail){
        springJavaMailer.sendMail(notificationEmail);
    }
}
