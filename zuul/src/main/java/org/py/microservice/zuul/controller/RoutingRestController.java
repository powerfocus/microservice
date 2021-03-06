package org.py.microservice.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cqpythagoras
 * @date 2021-03-06
 */
@RestController
public class RoutingRestController {

    @GetMapping({"/available"})
    public String available() {
        return "Spring in Action";
    }

    @GetMapping({"/checked-out"})
    public String checkOut() {
        return "Spring Boot in Action";
    }

}
