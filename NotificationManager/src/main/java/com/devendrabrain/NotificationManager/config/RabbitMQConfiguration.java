package com.devendrabrain.NotificationManager.config;

import com.devendrabrain.NotificationManager.constant.AMQPKeys;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue registerQueue() {
        return new Queue(AMQPKeys.QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(AMQPKeys.EXHANGE);
    }

    @Bean
    public Binding bindExchageToQueue() {
        return BindingBuilder.bind(registerQueue()).to(directExchange()).with(AMQPKeys.ROUNTING_KEY);
    }

}
