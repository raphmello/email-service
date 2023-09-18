package com.raphael.emailservice.controllers;

import com.raphael.emailservice.application.EmailSenderService;
import com.raphael.emailservice.core.EmailSenderUseCase;
import com.raphael.emailservice.core.entity.EmailRequest;
import com.raphael.emailservice.core.exceptions.EmailServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderUseCase emailSenderUseCase;

    public EmailSenderController(EmailSenderService emailSenderUseCase) {
        this.emailSenderUseCase = emailSenderUseCase;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            emailSenderUseCase.sendEmail(request.toEmail(), request.subject(), request.body());
            return ResponseEntity.ok("email sent successfully");
        } catch (EmailServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
