package com.user.information.system.service.impl;

import com.user.information.system.model.User;
import com.user.information.system.pojos.Course;
import com.user.information.system.repository.UserRepository;
import com.user.information.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUserNumber(long userNumber) {
        return repository.findByUserNumber(userNumber);
    }

    @Override
    public User findByEmail(String userEmail) {
        return repository.findByEmail(userEmail);
    }

    @Override
    public List<User> findAllByOrderByRatingDesc() {
        return repository.findAllByOrderByRatingDesc();
    }

    @Override
    public void updateUserCourseName(long userNumber, String oldName,  String newName) {
        User user = repository.findByUserNumber(userNumber);
        List<Course> courseList = user.getCourseList();
        courseList.forEach(course -> {
                    if (course.getName().equals(oldName)) {
                        course.setName(newName);
                    }
                });
        user.setCourseList(courseList);
        repository.save(user);
    }

    @Override
    public void updateUserCourseDescription(long userNumber, String courseName, String courseDescription) {
        User user = repository.findByUserNumber(userNumber);
        List<Course> courseList = user.getCourseList();

        // replace the '_' with ' ' from courseName and courseDescription
        final String courseName_ = courseName.replace('_',' ');
        final String courseDescription_ = courseDescription.replace('_',' ');

        courseList.forEach(course -> {
                    if(course.getName().equals(courseName_)) {
                        course.setDescription(courseDescription_);
                    }
                });
        user.setCourseList(courseList);
        repository.save(user);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        repository.save(user);
    }

    @Override
    public void saveAllUsers(List<User> users)
    {
        repository.saveAll(users);
    }

    @Override
    public void deleteUserById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllUsers()
    {
        repository.deleteAll();
    }
}
