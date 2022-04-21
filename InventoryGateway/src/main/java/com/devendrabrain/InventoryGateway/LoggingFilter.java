package com.devendrabrain.InventoryGateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class LoggingFilter implements GatewayFilter {

    public static final String RequestIdHeader = "x-rs-requestid";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(
                exchange.mutate().request(
                        exchange.getRequest().mutate().headers(httpHeaders -> {

                           if(httpHeaders.get(RequestIdHeader) == null)
                           {
                               String traceId = UUID.randomUUID().toString();
                               System.out.println(traceId);
                               httpHeaders.set(RequestIdHeader,traceId);
                           }
                        }).build()).build());
    }
}
