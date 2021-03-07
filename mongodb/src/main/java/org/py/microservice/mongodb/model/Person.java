package org.py.microservice.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private int age;
}
