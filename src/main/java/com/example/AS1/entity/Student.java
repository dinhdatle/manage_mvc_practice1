package com.example.AS1.entity;


import jakarta.persistence.*;

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


    public Student() {}

    public Student(Long id, String name, String email, String phone, Class studentClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
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
}
