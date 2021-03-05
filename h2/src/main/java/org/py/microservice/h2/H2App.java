package org.py.microservice.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2App {
    public static void main(String[] args) {
        SpringApplication.run(H2App.class, args);
    }
}
