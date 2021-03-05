package org.py.microservice.h2.repo;

import org.py.microservice.h2.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {
}
