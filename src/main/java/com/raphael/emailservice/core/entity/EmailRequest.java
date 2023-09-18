package com.raphael.emailservice.core.entity;

public record EmailRequest(String toEmail, String subject, String body) {
}
