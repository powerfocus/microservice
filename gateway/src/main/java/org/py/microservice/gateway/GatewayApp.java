package org.py.microservice.gateway;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author cqpythagoras
 * @date 2021-03-06
 */
@Log
@SpringBootApplication
public class GatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

    @Bean
    public RouteLocator custormRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route1", r -> r.path("/csdn")
                            .uri("http://localhost:8011/gateway"))
                .build();
    }

}
