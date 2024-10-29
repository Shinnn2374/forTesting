package com.example.RestAssuredReqres.pojos.register;

public class SuccessfulReg
{
    private String email;
    private String password;

    public SuccessfulReg(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SuccessfulReg() {
    }

    public String getEmail() {
        return  email;
    }
}
