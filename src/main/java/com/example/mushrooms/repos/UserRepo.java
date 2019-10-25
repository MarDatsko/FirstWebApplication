package com.example.mushrooms.repos;

import com.example.mushrooms.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
