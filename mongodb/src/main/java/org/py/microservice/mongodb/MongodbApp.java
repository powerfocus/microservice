package org.py.microservice.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"org.py.microservice.mongodb.repo"})
public class MongodbApp {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApp.class, args);
    }
}
