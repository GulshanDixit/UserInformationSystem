package com.user.information.system.service;

import com.user.information.system.model.User_Old;

import java.util.List;

public interface User_OldService {

    List<User_Old> findAll();

    void deleteAll();
}
