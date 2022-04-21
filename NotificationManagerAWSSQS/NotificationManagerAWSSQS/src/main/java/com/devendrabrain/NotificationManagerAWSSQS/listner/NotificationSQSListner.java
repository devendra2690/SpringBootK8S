package com.devendrabrain.NotificationManagerAWSSQS.listner;

import com.devendrabrain.NotificationManagerAWSSQS.dto.NotificationDTO;
import com.devendrabrain.NotificationManagerAWSSQS.service.EmailService;
import com.devendrabrain.NotificationManagerAWSSQS.util.JSONUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class NotificationSQSListner {

    private Logger logger = LoggerFactory.getLogger(NotificationSQSListner.class);


    @Autowired
    EmailService emailService;

    @SqsListener(value = "inventoryQueue",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void notificationConsumer(String message) throws IOException {
        logger.info("NotificationSQSListner:notificationConsumer message from SQS Queue {} "+message);

        NotificationDTO notificationDTO = null;
        if(message != null) {
            notificationDTO = JSONUtils.toObject(message,NotificationDTO.class);
        }

        logger.info("NotificationSQSListner:notificationConsumer Sending Email "+notificationDTO);

        emailService.sendMailMessage(notificationDTO);
    }

}
