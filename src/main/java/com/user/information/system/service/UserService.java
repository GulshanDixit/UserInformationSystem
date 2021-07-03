package com.user.information.system.service;

import com.user.information.system.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUserNumber(long userNumber );

    User findByEmail(String userEmail);

    List<User> findAllByOrderByRatingDesc();

    void saveOrUpdateUser(User user);

    void saveAllUsers(List<User> users);

    void deleteUserById(String id);

    void deleteAllUsers();
}
