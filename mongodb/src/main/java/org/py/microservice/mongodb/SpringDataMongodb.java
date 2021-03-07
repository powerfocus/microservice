package org.py.microservice.mongodb;

import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import lombok.extern.java.Log;
import org.py.microservice.mongodb.model.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
@Log
public class SpringDataMongodb {
    public static void main(String[] args) {
        MongoTemplate mongoOps = new MongoTemplate(MongoClients.create(), "database");
        mongoOps.insert(Person.builder()
                .name("Joe")
                .age(34)
                .build());
        log.info(mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class) + "");

        mongoOps.dropCollection("person");
    }
}
