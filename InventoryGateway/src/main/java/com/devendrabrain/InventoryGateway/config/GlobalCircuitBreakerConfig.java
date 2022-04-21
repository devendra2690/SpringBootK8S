package com.devendrabrain.InventoryGateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;

import java.time.Duration;

@Configuration
public class GlobalCircuitBreakerConfig {

    public CircuitBreakerConfig circuitBreakerConfig () {

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig
                        .SlidingWindowType.TIME_BASED)
                // Count-based: the circuit breaker switches from a closed state to an open state
                // when the last N requests have failed or timeout.
                // Time-based: the circuit breaker switches from a closed state
                // to an open state when the last N time unit has failed or timeout.
                // Sliding-window-type: we will use a count-based circuit breaker type.
                // In this type, the circuit will trip or move to an open state based on each incoming request.
                .slidingWindowSize(5)
                //Sliding-window-size: we will use this parameter to record the last N requests to make the circuit breaker trip or open.
                // Here, we will record the last 5 requests.
                .failureRateThreshold(30)
                // Failure-rate-threshold: it shows the percentage of the total sliding-window-size that fails
                // and will cause the circuit breaker trips to open state.
                // This means, with a configuration of 40%, 2 out of 5 failed requests will cause the circuit breaker trips to open state.
                .maxWaitDurationInHalfOpenState(Duration.ofSeconds(3000))
                // Number of time it will wait in Half Open State before trying to hit request again
                .permittedNumberOfCallsInHalfOpenState(2)
                // How Many Call should it try in Half open state to check if Server issue is resolved or not
                .waitDurationInOpenState(Duration.ofSeconds(5000))
                // Number of time it will wait in Open State before going into Half Open state
                .recordException(throwable -> {
                    System.out.println(throwable.getMessage());
                    // We check check here API thrown exception and check if it is valid error or not and can it be
                    // counted as a failure
                    return true;
                }).build();
        return circuitBreakerConfig;
    }

    public TimeLimiterConfig timeLimiterConfig() {

        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2000)).build();

        return timeLimiterConfig;
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(timeLimiterConfig())
                .circuitBreakerConfig(circuitBreakerConfig())
                .build());

       /* return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(2)).build()).build());*/
/*
       We can also set up multiple circuit breakers with the same configuration
       by providing a list of circuit breaker ids to the same method:

        return factory -> factory.configure(builder -> builder.circuitBreakerConfig(circuitBreakerConfig)
                        .timeLimiterConfig(timeLimiterConfig).build(),
                "circuitBreaker1", "circuitBreaker2", "circuitBreaker3");*/
    };

/*
    @Bean
    public Customizer<SpringCloudCircuitBreakerFilterFactory> springCloudCircuitBreakerFilterFactoryCustomizer() {

        return factory -> factory.(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(timeLimiterConfig())
                .circuitBreakerConfig(circuitBreakerConfig())
                .build());
    }*/
}
