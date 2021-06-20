package com.user.information.system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "users")
public class User {

    @Id
    private String id;
    private String name;
    private long userNumber;
    private String email;
    private List<String> courseList;
    private float rating;

    public User() {
    }

    public User(String name, long userNumber, String email, List<String> courseList, float rating) {
        this.name = name;
        this.userNumber = userNumber;
        this.email = email;
        this.courseList = courseList;
        this.rating = rating;
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

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userNumber=" + userNumber +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                ", gpa=" + rating +
                '}';
    }
}
