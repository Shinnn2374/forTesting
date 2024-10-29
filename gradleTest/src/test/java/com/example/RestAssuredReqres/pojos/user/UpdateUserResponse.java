package com.example.RestAssuredReqres.pojos.user;

import java.util.Date;

public class UpdateUserResponse
{
    private String name;
    private String job;
    private Date updatedAt;

    public UpdateUserResponse(String name, String job, Date updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public UpdateUserResponse() {
    }

    public String getName() {
        return name;
    }
}
