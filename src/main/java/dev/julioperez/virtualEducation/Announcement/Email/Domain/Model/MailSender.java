package dev.julioperez.virtualEducation.Announcement.Email.Domain.Model;

public interface MailSender {
    void sendMail(NotificationEmail notificationEmail);
}
