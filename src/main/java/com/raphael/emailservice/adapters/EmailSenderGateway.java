package com.raphael.emailservice.adapters;

public interface EmailSenderGateway {
    void sendEmail(final String toEmail, final String subject, final String body);
}
