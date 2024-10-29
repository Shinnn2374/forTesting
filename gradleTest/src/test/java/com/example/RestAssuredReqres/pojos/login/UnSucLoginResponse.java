package com.example.RestAssuredReqres.pojos.login;

public class UnSucLoginResponse
{
    private String error;

    public UnSucLoginResponse(String error) {
        this.error = error;
    }

    public UnSucLoginResponse() {
    }

    public String getError() {
        return error;
    }
}
