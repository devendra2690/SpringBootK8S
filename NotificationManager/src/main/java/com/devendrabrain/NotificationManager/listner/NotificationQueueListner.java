package com.devendrabrain.NotificationManager.listner;

import java.io.IOException;

import com.devendrabrain.NotificationManager.constant.AMQPKeys;
import com.devendrabrain.NotificationManager.dto.NotificationDTO;
import com.devendrabrain.NotificationManager.service.impl.EmailService;
import com.devendrabrain.NotificationManager.util.JSONUtils;
import lombok.SneakyThrows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationQueueListner implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(NotificationQueueListner.class);

    @Autowired
    EmailService emailService;

    /*


    @RabbitListener(queues = AMQPKeys.QUEUE)
    public void consumerNotification(Message message) {
    }*/

    @SneakyThrows
    @Override
    public void onMessage(Message message) {

        logger.info("NotificationQueueListner:onMessage Message received "+message);
        System.out.println(message);
        NotificationDTO notificationDTO = null;
        String json = new String(message.getBody());

        if(json != null) {

            try {
                notificationDTO = JSONUtils.toObject(json,NotificationDTO.class);
            } catch (IOException e) {
                logger.error("NotificationQueueListner:onMessage Error occured ", e);
                e.printStackTrace();
            }
        }

        logger.info("NotificationQueueListner:onMessage Sending email ", notificationDTO);
        emailService.sendEmail(notificationDTO);
    }
}
