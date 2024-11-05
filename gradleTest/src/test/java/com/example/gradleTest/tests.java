package com.example.gradleTest;

import com.example.gradleTest.restAssured.Specification;
import com.example.gradleTest.restAssured.pojos.PostMethod.PostUserRequest;
import com.example.gradleTest.restAssured.pojos.PostMethod.PostUserResponse;
import com.example.gradleTest.restAssured.pojos.Reg.SucReq;
import com.example.gradleTest.restAssured.pojos.Reg.SucRes;
import com.example.gradleTest.restAssured.pojos.Reg.UnsucReq;
import com.example.gradleTest.restAssured.pojos.Reg.UnsucRes;
import com.example.gradleTest.restAssured.pojos.datum.ResourceData;
import com.example.gradleTest.restAssured.pojos.datum.UserData;
import com.example.gradleTest.restAssured.pojos.log.SucLogReq;
import com.example.gradleTest.restAssured.pojos.log.SucLogRes;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class tests
{
    private static final String url = "https://reqres.in/";

    @Test
    @Owner("Борисов М.Р.")
    @Description("Тест проверяющий возвращение полного списка пользователей")
    public void getAllTest()
    {
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        Assert.assertNotNull(users);
    }

    @Test
    public void getSingleUserTest()
    {
        UserData asserUser = new UserData(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        UserData user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", UserData.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(asserUser.getId(),user.getId());
        Assert.assertEquals(asserUser.getAvatar(),user.getAvatar());
        Assert.assertEquals(asserUser.getEmail(),user.getEmail());
        Assert.assertEquals(asserUser.getFirst_name(),user.getFirst_name());
        Assert.assertEquals(asserUser.getLast_name(),user.getLast_name());
    }

    @Test
    public void singleUserNotFoundTest()
    {
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec404());
        UserData user = given()
                .when()
                .get("api/users/23")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", UserData.class);
        Assert.assertNull(user);
    }

    @Test
    public void getAllResourcesTest()
    {
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        List<ResourceData> resource = given()
                .when()
                .get("api/unknow")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ResourceData.class);
        Assert.assertNotNull(resource);
    }

    @Test
    public void getSingleResourceTest()
    {
        Integer id = 2;
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        ResourceData resource = given()
                .when()
                .get("api/unknow/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", ResourceData.class);
        Assert.assertNotNull(resource);
        Assert.assertEquals(resource.getId(),id);
    }

    @Test
    public void singleResourceNotFoundTest()
    {
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec404());
        ResourceData resource = given()
                .when()
                .get("api/unknow/23")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", ResourceData.class);
        Assert.assertNull(resource);
    }

    @Test
    public void createUserTest()
    {
        PostUserRequest user = new PostUserRequest("morpheus","leader");
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec201());
        PostUserResponse response = given()
                .when()
                .body(user)
                .post("api/users")
                .then().log().all()
                .extract().body().jsonPath().getObject("", PostUserResponse.class);
        Assert.assertEquals(user.getName(),response.getName());
        Assert.assertEquals(user.getJob(),response.getJob());
    }

    @Test
    public void deleteTest()
    {
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec204());
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void successRegTest()
    {
        Integer id = 4;
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        SucReq request = new SucReq("eve.holt@reqres.in","pistol");
        SucRes response = given()
                .when()
                .body(request)
                .post("api/register")
                .then().log().all()
                .extract().body().jsonPath().getObject("", SucRes.class);
        Assert.assertEquals(response.getId(),id);
    }

    @Test
    public void unsuccessRegTest()
    {
        String assertError = "Missing password";
        UnsucReq request = new UnsucReq("sydney@fife");
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec400());
        UnsucRes response = given()
                .when()
                .body(request)
                .post("api/register")
                .then().log().all()
                .extract().body().jsonPath().getObject("", UnsucRes.class);
        Assert.assertEquals(assertError,response.getError());
    }

    @Test
    public void successLogTest()
    {
        SucLogRes res = new SucLogRes("QpwL5tke4Pnpja7X4");
        SucLogReq request = new SucLogReq("eve.holt@reqres.in","cityslicka");
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec200());
        SucLogRes response = given()
                .when()
                .body(request)
                .post("api/login")
                .then().log().all()
                .extract().body().jsonPath().getObject("", SucLogRes.class);
        Assert.assertEquals(response.getToken(),res.getToken());
    }

    @Test
    public void unsuccessLogTest()
    {
        String error = "Missing password";
        UnsucReq request = new UnsucReq("peter@klaven");
        Specification.installSpecification(Specification.requestSpecification(url), Specification.responseSpec400());
        UnsucRes res = given()
                .when()
                .body(request)
                .post("api/login")
                .then().log().all()
                .extract().body().jsonPath().getObject("", UnsucRes.class);
        Assert.assertEquals(error,res.getError());
    }

}
