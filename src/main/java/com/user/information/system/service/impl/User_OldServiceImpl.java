package com.user.information.system.service.impl;

import com.user.information.system.model.User;
import com.user.information.system.model.User_Old;
import com.user.information.system.repository.User_OldRepository;
import com.user.information.system.service.User_OldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_OldServiceImpl implements User_OldService {

    @Autowired
    private User_OldRepository repository;


    public List<User_Old> findAll() {
        return repository.findAll();
    }

    public void deleteAll()
    {
        repository.deleteAll();
    }

}
