package com.user.information.system.pojos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Course {
    public Course(String name, String description) {
        this.id = new ObjectId();
        this.name = name;
        this.description = description;
    }
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id.toString() + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }

    @Id
    private ObjectId id;
    private String name;
    private String description;

}
