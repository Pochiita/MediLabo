package com.gateway.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class RouterConfig {

    /**
     * Defines custom routes for the Gateway service.
     *
     * @param builder The RouteLocatorBuilder used to construct routes.
     * @return The configured RouteLocator instance.
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/patients/**")
                        .uri("http://patients:8092"))
                .route(r -> r.path("/notes/**")
                        .uri("http://notes:8093"))
                .route(r -> r.path("/risks/**")
                        .uri("http://diabete:8094"))
                .build();
    }
}
