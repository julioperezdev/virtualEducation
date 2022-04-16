package dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway;

import dev.julioperez.virtualEducation.Announcement.Email.Application.Service.MailSenderService;
import dev.julioperez.virtualEducation.Announcement.Email.Domain.Exception.ErrorOccurredWhenSendingEmailException;
import dev.julioperez.virtualEducation.Announcement.Email.Domain.Model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SpringJavaMailer {

    private final JavaMailSender mailSender;
    //@Value("")
    //private final String emailFrom;

    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("contactos@lineaesperanza.com");
            //messageHelper.setFrom(emailFrom);
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
            //messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new ErrorOccurredWhenSendingEmailException(notificationEmail.getRecipient());
        }
    }


}
