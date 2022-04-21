package com.devendrabrain.InventoryGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelayedOrderController {

    @GetMapping("/circuitBreaker")
    public String delayedAPI() throws InterruptedException {

        Thread.sleep(3000);
        return "This is delayed API for circuit breaker";
    };

    @GetMapping("/fallback")
    public String fallBackMethod() {
        return "This is FALLBACK METHOD delayed API for circuit breaker";
    };
}
