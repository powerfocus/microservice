package org.py.microservice.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Person {
    @MongoId
    private String id;
    private String name;
    private int age;
}
