package com.user.information.system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User_Old {

    @Id
    private String id;
    private String name;
    private long userNumber;
    private String email;
    private float rating;
    private List<String> courseList;

    public User_Old() {
    }

    public User_Old(String name, long userNumber, String email, float rating, List<String> courseList) {
        this.name = name;
        this.userNumber = userNumber;
        this.email = email;
        this.rating = rating;
        this.courseList = courseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userNumber=" + userNumber +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                ", courseList=" + courseList.toString() +
                '}';
    }
}
