package org.py.microservice.mongodb.repo;

import org.bson.types.ObjectId;
import org.py.microservice.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author cqpythagoras
 * @date 2021-03-07
 */
public interface PersonRepo extends MongoRepository<Person, String> {

}
