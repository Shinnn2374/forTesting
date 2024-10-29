package com.example.RestAssuredReqres.pojos.login;


public class SucLoginResponse
{
    private String token;

    public SucLoginResponse(String token) {
        this.token = token;
    }

    public SucLoginResponse() {
    }

    public String getToken() {
        return token;
    }
}
