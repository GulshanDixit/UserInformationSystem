package com.user.information.system.service;

import com.user.information.system.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUserNumber(long userNumber );

    User findByEmail(String userEmail);

    List<User> findAllByOrderByRatingDesc();

    void updateUserCourseName(long userNumber, String oldName, String newName);

    void updateUserCourseDescription(long userNumber, String courseName, String courseDescription);

    void saveOrUpdateUser(User user);

    void saveAllUsers(List<User> users);

    void deleteUserById(String id);

    void deleteAllUsers();
}
