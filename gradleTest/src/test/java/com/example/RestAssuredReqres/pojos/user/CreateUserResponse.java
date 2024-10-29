package com.example.RestAssuredReqres.pojos.user;

import java.util.Date;

public class CreateUserResponse
{
    public String name;
    public String job;
    public String id;
    public Date createdAt;

    public CreateUserResponse(String name, String job, String id, Date createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public CreateUserResponse() {
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
