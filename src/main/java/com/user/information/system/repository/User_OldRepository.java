package com.user.information.system.repository;

import com.user.information.system.model.User;
import com.user.information.system.model.User_Old;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface User_OldRepository extends MongoRepository<User_Old,String> {

}
