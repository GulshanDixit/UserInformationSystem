package com.user.information.system.service;

public interface TypeMigrateService {

    void MigrateUser_OldToUser(User_OldService user_oldService, UserService userService);
}
