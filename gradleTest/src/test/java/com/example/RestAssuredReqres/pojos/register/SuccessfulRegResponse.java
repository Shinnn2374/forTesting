package com.example.RestAssuredReqres.pojos.register;

public class SuccessfulRegResponse
{
    private Integer id;
    private String token;

    public SuccessfulRegResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessfulRegResponse() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
