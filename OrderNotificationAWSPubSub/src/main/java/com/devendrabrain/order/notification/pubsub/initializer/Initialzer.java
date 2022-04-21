package com.devendrabrain.order.notification.pubsub.initializer;

import com.devendrabrain.order.notification.pubsub.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Initialzer  implements CommandLineRunner {

    @Autowired
    SubscriptionService subscriptionService;

    @Override
    public void run(String... args) throws Exception {

        subscriptionService.subscribeToSNS("arn:aws:sns:us-east-1:527629206502:OrderPublisher", Arrays.asList("devenpatil062@gmail.com","devendra_patil26@yahoo.com"));
    }
}
