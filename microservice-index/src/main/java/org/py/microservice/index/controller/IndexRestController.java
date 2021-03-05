package org.py.microservice.index.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cqpythagoras
 */
@RestController
@RequestMapping("/")
public class IndexRestController {
    private final UserProxy userProxy;

    public IndexRestController(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    public String index() {
        return "micro service index-index()";
    }

    @GetMapping({"/user/{id}"})
    public String user(@PathVariable(required = false, value = "id") Long id) {
        return userProxy.hello(id);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name = "", value = "")
    })
    @GetMapping({"/user/order"})
    public String order() {
        return userProxy.order();
    }
}
