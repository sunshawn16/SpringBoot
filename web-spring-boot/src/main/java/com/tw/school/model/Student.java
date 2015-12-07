package com.tw.school.model;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Column(name = "NAME")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ADDRESS")
    private String address;

    public Student() {
    }

    public Student(String name, long id, int age, String address) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
