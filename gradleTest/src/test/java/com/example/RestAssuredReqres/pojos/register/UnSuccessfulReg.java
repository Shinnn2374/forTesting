package com.example.RestAssuredReqres.pojos.register;

public class UnSuccessfulReg
{
    private String email;

    public UnSuccessfulReg(String email) {
        this.email = email;
    }

    public UnSuccessfulReg() {
    }

    public String getEmail() {
        return email;
    }
}
