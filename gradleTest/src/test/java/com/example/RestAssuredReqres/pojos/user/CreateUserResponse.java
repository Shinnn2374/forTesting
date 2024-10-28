package com.example.RestAssuredReqres.pojos.user;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse
{
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
