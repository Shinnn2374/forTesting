package com.example.gradleTest.restAssured.pojos.Reg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SucRes
{
    private Integer id;
    private String token;
}
