package com.example.gradleTest.restAssured.pojos.datum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceData
{
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;
}
