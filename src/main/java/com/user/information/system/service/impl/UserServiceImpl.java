package com.user.information.system.service.impl;

import com.user.information.system.model.User;
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
