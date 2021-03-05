package org.py.microservice.h2.repo;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.microservice.h2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void test() {
        TestCase.assertNotNull(userRepo);
    }

    @Test
    public void save() {
        List<User> users = Arrays.asList(
                User.builder()
                        .name("张三")
                        .age(20)
                        .balance(BigDecimal.valueOf(180.00))
                        .build(),
                User.builder()
                        .name("李四")
                        .age(22)
                        .balance(BigDecimal.valueOf(100.00))
                        .build()
        );
        userRepo.saveAll(users);
    }

    @Test
    public void findAll() {
        userRepo.findAll()
                .forEach(System.out::println);
    }
}