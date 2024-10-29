package com.example.RestAssuredReqres.pojos.login;

public class UnSucLogin
{
    private String email;

    public UnSucLogin(String email) {
        this.email = email;
    }

    public UnSucLogin() {
    }

    public String getEmail() {
        return email;
    }
}
