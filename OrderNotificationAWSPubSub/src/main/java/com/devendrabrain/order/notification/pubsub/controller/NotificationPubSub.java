package com.devendrabrain.order.notification.pubsub.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.devendrabrain.order.notification.pubsub.dto.NotificationDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AWSSNSMgr")
public class NotificationPubSub {

    private Logger logger = LoggerFactory.getLogger(NotificationPubSub.class);


    @Autowired
    AmazonSNSClient amazonSNSClient;
    private String TOPIC_ARN = "arn:aws:sns:us-east-1:527629206502:OrderPublisher";


    @PostMapping("/post/groupnotification")
    public String publishOrderDetails(@RequestBody NotificationDTO notificationDTO) {

        logger.info("NotificationPubSub:publishOrderDetails received request ", notificationDTO);
        PublishRequest publishRequest =
                new PublishRequest(TOPIC_ARN,notificationDTO.toString(),"SNS SpringBoot" );

        if(notificationDTO != null) {
            logger.info("NotificationPubSub:publishOrderDetails publishing request ", notificationDTO);
            amazonSNSClient.publish(publishRequest);
        }

        return "Message published Succesfully ..!!";
    }

}
