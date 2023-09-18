package com.raphael.emailservice.core;

public interface EmailSenderUseCase {
    void sendEmail(final String toEmail, final String subject, final String body);
}
