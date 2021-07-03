package com.user.information.system.controller;

import com.user.information.system.model.User;
import com.user.information.system.pojos.HealthStatus;
import com.user.information.system.service.TypeMigrateService;
import com.user.information.system.service.UserService;
import com.user.information.system.service.User_OldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private User_OldService user_oldService;

    @Autowired
    private TypeMigrateService typeMigrateService;

    @GetMapping("/check/health")
    public HealthStatus getHealthStatus() {
        HealthStatus healthStatus = new HealthStatus(200, "test api working successfully");
        return healthStatus;
    }

    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return  userService.findAll();
    }

    @GetMapping("/byUserNumber/{userNumber}")
    public User getUserByUserNumber(@PathVariable("userNumber") long userNumber)
    {
        return userService.findByUserNumber(userNumber);
    }

    @GetMapping("/byEmail/{email}")
    public User getUserByEmail(@PathVariable("email") String email)
    {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/orderByRating")
    public List<User> findAllByOrderByRatingDesc() {
        return userService.findAllByOrderByRatingDesc();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{userNumber}")
    public ResponseEntity<?> deleteUserByUserNumber(@PathVariable long userNumber) {
        userService.deleteUserById(userService.findByUserNumber(userNumber).getId());
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/typemigrate/oldUserToNewUser")
    public ResponseEntity<?> migrateOldUserToNewUser()
    {
        try {
            typeMigrateService.MigrateUser_OldToUser(user_oldService, userService);
        }
        catch(Exception e)
        {
            return new ResponseEntity("User type migrated failed due to: " + e.toString(), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity("User type migrated successfully", HttpStatus.OK);
    }


}
