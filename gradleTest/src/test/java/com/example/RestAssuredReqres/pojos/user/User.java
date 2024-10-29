package com.example.RestAssuredReqres.pojos.user;

public class User
{
    private String name;
    private String job;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public User() {
    }

    public String getName() {
        return name;
    }
}
