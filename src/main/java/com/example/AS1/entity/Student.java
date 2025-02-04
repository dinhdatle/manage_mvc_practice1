package com.example.AS1.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class studentClass;

    @OneToMany(mappedBy = "student")
    private List<Score> scores =  new ArrayList<>();


    public Student() {}

    public Student(Long id, String name, String email, String phone, Class studentClass, List<Score> scores) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
        this.scores = scores;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }
    public Class getStudentClass() {
        return studentClass;
    }
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
    public List<Score> getScores() {
        return scores;
    }
}
