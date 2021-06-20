package com.user.information.system.controller;

import com.user.information.system.model.User;
import com.user.information.system.service.UserService;
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

    @GetMapping(value = "/orderByGpa")
    public List<User> findAllByOrderByGpaDesc() {
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

}