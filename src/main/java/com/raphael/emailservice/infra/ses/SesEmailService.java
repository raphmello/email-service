package com.raphael.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.raphael.emailservice.adapters.EmailSenderGateway;
import com.raphael.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SesEmailService implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value(value = "${aws.verified-email}")
    private String verifiedEmail;

    public SesEmailService(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(verifiedEmail)
                .withDestination(new Destination().withToAddresses(toEmail))
                .withMessage(
                        new Message()
                                .withSubject(new Content(subject))
                                .withBody(new Body().withText(new Content(body)))
                );
        try {
            amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Failure while sending email", e);
        }
    }
}
