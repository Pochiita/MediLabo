package com.gateway.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/patients/**")
                        .uri("http://localhost:8092"))  // Use patients microservice
                .route(r -> r.path("/notes/**")
                        .uri("http://localhost:8093"))  // Use notes microservice
                .route(r -> r.path("/risks/**")
                        .uri("http://healthrisks:8094"))  // Use healthrisk  microservice*/
                .build();
    }
}
