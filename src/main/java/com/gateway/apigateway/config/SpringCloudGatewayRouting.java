package com.gateway.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin("http://localhost:3000/")
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r->r.path("/api/auth/**").uri("http://localhost:8089"))
                .route("user-service", r->r.path("/api/admin/**").uri("http://localhost:8089")) //static routing
                .route("user-service", r->r.path("/api/forgotpwd/**").uri("http://localhost:8089")) //static routing
                .route("event-service", r->r.path("/api/**").uri("http://localhost:8088")) //dynamic routing
                .route("event-service", r->r.path("/api/tag").uri("http://localhost:8088")) //dynamic routing
                .route("event-service", r->r.path("/notification/**").uri("http://localhost:8088")) //dynamic routing
                .route("event-service", r->r.path("/push-notifications/**").uri("http://localhost:8088")) //dynamic routing
                .build();
    }
}
