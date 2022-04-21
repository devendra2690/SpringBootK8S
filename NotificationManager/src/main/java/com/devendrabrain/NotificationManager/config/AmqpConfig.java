/*******************************************************************************
 * Copyright (c) 2018, RevSpring, Inc.
 * All Rights Reserved.
 * This software is proprietary to RevSpring, Inc.
 * Your access to this software is governed by the terms of your license agreement with RevSpring, Inc.
 * Any other use of the software is strictly prohibited.
 * @author Trilok Rajan 
 *******************************************************************************/

package com.devendrabrain.NotificationManager.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmqpConfig {

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(jsonMessageConverter());
		return template;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}