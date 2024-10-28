package com.example.RestAssuredReqres.pojos.datum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserData
{
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}