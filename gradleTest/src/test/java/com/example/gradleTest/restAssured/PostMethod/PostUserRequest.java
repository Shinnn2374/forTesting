package com.example.gradleTest.restAssured.PostMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostUserRequest
{
    private String name;
    private String job;
}
