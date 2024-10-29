package com.example.RestAssuredReqres.pojos.register;

public class UnSuccessfulRegResponse
{
    private String error;

    public UnSuccessfulRegResponse(String error) {
        this.error = error;
    }

    public UnSuccessfulRegResponse() {
    }

    public String getError() {
        return error;
    }
}
