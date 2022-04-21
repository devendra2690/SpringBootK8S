package com.devendrabrain.NotificationManager.config;

import com.devendrabrain.NotificationManager.constant.AMQPKeys;
import com.devendrabrain.NotificationManager.listner.NotificationQueueListner;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class RabbitListenerConfig {

    @Autowired
    NotificationQueueListner notificationQueueListner;

    @Bean
    SimpleMessageListenerContainer comQueueContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(AMQPKeys.QUEUE);
        container.setMessageListener(notificationQueueListner);
        container.setDefaultRequeueRejected(false);
        return container;
    }
}
