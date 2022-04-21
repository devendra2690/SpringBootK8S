package com.devendrabrain.OrderManagement.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationQueuePublisher {

    private Logger logger = LoggerFactory.getLogger(NotificationQueuePublisher.class);

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void publish(Object object, String exchange, String bindingBuilder) {

        logger.info("NotificationQueuePublisher:publish in the class");
        if (object != null) {
            
            logger.info("Sending message to Rabbit MQ for exchange "+exchange+" and Routing key "+bindingBuilder);
            /*
             * Send message to RabbitMQ
             */
            try {
                rabbitTemplate.convertAndSend(exchange, bindingBuilder, object);
            } catch (Exception exc) {

            }

        } else {

        }
    }
}
