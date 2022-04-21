package com.devendrabrain.NotificationManagerAWSSQS.service;

import com.devendrabrain.NotificationManagerAWSSQS.dto.NotificationDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private MailSender mailSender;

    public void sendMailMessage(NotificationDTO notificationDTO) {

        logger.info("EmailService:sendMailMessage message from SQS Queue {} from devenpatil062@gmail.com to "+notificationDTO.getEmail());


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("devenpatil062@gmail.com");
        simpleMailMessage.setTo("devenpatil062@gmail.com");
        simpleMailMessage.setSubject("AWS SES Invoice for Order Id : "+notificationDTO.getOrderId());

        String text= "Invoice for the Item for Total bill of "+notificationDTO.getTotalPrice()+". Items in Invoice are  ";

        text = text.concat(notificationDTO.getInventoryDetails().entrySet().stream().map(longStringEntry -> longStringEntry.getKey()+"-"+longStringEntry.getValue()).collect(Collectors.joining(",")));

        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }
}
