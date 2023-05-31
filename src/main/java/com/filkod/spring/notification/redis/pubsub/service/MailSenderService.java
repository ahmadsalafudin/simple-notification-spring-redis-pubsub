package com.filkod.spring.notification.redis.pubsub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailSenderService {

    @Value("${mail.send.from}")
    private String mailFrom;
    private final JavaMailSender mailSender;
    public void sendMailNotification(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(mailFrom);
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);

            mailSender.send(message);
            log.info("Mail Notification already has sent with message "+ body);
        } catch (Exception er) {
            log.info("Mail Notification failed to sent "+ er.getMessage());
        }
    }
}
