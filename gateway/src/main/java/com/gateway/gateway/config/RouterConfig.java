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
                .route(r -> r.path("/patient/**")
                        .uri("http://localhost:8092"))  // Use patients microservice
                /*.route(r -> r.path("/api/notes/**")
                        .uri("http://notes-ms:9000"))  // Use notes microservice
                .route(r -> r.path("/api/healthrisks/**")
                        .uri("http://healthrisks:9003"))  // Use healthrisk  microservice*/
                .build();
    }
}
