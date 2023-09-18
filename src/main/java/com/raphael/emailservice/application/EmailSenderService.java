package com.raphael.emailservice.application;

import com.raphael.emailservice.adapters.EmailSenderGateway;
import com.raphael.emailservice.core.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(final EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        emailSenderGateway.sendEmail(toEmail, subject, body);
    }
}
