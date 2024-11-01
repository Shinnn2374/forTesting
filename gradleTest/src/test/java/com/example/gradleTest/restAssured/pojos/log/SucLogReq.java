package com.example.gradleTest.restAssured.pojos.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SucLogReq
{
    private String email;
    private String password;
}
