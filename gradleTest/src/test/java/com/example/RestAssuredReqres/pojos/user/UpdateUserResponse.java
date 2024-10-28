package com.example.RestAssuredReqres.pojos.user;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse
{
    private String name;
    private String job;
    private Date updatedAt;
}
