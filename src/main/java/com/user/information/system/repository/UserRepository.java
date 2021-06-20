package com.user.information.system.repository;

import com.user.information.system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUserNumber(long userNumber );

    User findByEmail(String userEmail);

    List<User> findAllByOrderByRatingDesc();
}
