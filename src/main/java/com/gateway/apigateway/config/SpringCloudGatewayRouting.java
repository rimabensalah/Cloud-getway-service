package com.gateway.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r->r.path("/api/auth/**").uri("http://localhost:8089")) //static routing
                .route("event-service", r->r.path("/api/event/**").uri("http://localhost:8088")) //dynamic routing
                .build();
    }
}
