package dev.julioperez.virtualEducation.Announcement.Email.Domain.Exception;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class ErrorOccurredWhenSendingEmailException extends DomainError {

    public ErrorOccurredWhenSendingEmailException(String personToSend){
        super("error_occurred_when_sending_email", String.format("Exception occurred when sending mail to %s", personToSend));
    }
}