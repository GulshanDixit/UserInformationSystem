package com.user.information.system.service.impl;

import com.user.information.system.model.User;
import com.user.information.system.model.User_Old;
import com.user.information.system.pojos.Course;
import com.user.information.system.service.TypeMigrateService;
import com.user.information.system.service.UserService;
import com.user.information.system.service.User_OldService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeMigrateServiceImpl implements TypeMigrateService {

    @Override
    public void MigrateUser_OldToUser(User_OldService user_oldService, UserService userService) {
        List<User_Old> user_olds = user_oldService.findAll();

        List<User> users = user_olds.stream()
                .map(p -> ConvertUserOldToNewUser(p))
                .collect(Collectors.toList());
        user_oldService.deleteAll();;
        userService.saveAllUsers(users);
    }

    private User ConvertUserOldToNewUser(User_Old user_old)
    {
        User user = new User(user_old.getName(), user_old.getUserNumber(), user_old.getEmail(), user_old.getRating(), null);
        List<Course> courses = user_old.getCourseList()
                .stream()
                .map(p -> new Course(p,""))
                .collect(Collectors.toList());
        user.setCourseList(courses);
        return user;
    }
}
