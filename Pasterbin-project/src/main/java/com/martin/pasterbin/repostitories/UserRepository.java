package com.martin.pasterbin.repostitories;

import com.martin.pasterbin.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findUserById(Integer id);
}
