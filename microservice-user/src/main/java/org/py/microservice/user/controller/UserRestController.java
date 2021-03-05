package org.py.microservice.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cqpythagoras
 */
@RestController
@RequestMapping("/user")
public class UserRestController {
    @GetMapping({"{id}"})
    public String index(@PathVariable(required = false) Long id) {
        return "microservice user index()";
    }

    @GetMapping({"order"})
    public String order() {
        return "microservice user order 1";
    }
}
