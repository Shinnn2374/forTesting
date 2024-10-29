package com.example.RestAssuredReqres.pojos.login;

public class SucLogin
{
    private String email;
    private String password;

    public SucLogin(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public SucLogin() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
