package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;


    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User User(String name, Integer age) {
        User u = new User();
        u.age = age;
        u.name = name;
        return u;
    }
}
