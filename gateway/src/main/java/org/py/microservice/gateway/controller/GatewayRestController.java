package org.py.microservice.gateway.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cqpythagoras
 * @date 2021-03-06
 */
@Log
@RestController
@RequestMapping("/")
public class GatewayRestController {

    @GetMapping({"gateway"})
    public String gateway() {
        log.info("GatewayRestController.geteway().");
        return "This is a fallback";
    }

}
