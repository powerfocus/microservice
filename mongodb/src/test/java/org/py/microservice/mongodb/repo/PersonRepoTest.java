package org.py.microservice.mongodb.repo;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.microservice.mongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;

    @Test
    public void test() {
        TestCase.assertNotNull(personRepo);
    }

    @Test
    public void save() {
        Person person = Person.builder()
                .id("8")
                .name("王八")
                .age(40)
                .build();
        personRepo.save(person);
    }

    @Test
    public void findAll() {
        personRepo.findAll()
                .forEach(System.out::println);
    }

}