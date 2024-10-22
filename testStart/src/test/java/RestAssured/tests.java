package RestAssured;

import RestAssured.pojos.register.SuccessfulReg;
import RestAssured.pojos.register.SuccessfulRegResponse;
import RestAssured.pojos.register.UnSuccessfulReg;
import RestAssured.pojos.register.UnSuccessfulRegResponse;
import RestAssured.pojos.user.UpdateUserResponse;
import RestAssured.pojos.datum.ResourceData;
import RestAssured.pojos.datum.UserData;
import RestAssured.pojos.user.User;
import RestAssured.pojos.user.CreateUserResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class tests
{
    private static final String BASE_URL = "https://reqres.in/";

    @Test
    public void getUsersListTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().jsonPath().getList("data", UserData.class);
        Assert.assertNotNull(users);
    }

    @Test
    public void getUserByIdTest()
    {
        Integer id = 2;
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        UserData userData = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", UserData.class);
        Assert.assertEquals(userData.getId(), id);
    }

    @Test
    public void singleUserNotFoundTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec404());
        given()
                .when()
                .get("api/users/23")
                .then().log().all();
    }

    @Test
    public void getResourceListTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<ResourceData> resources = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().jsonPath().getList("data", ResourceData.class);
        Assert.assertNotNull(resources);
    }

    @Test
    public void getResourceByIdTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        Integer id = 2;
        ResourceData resource = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .extract().jsonPath().getObject("data", ResourceData.class);
        Assert.assertEquals(resource.getId(), id);
    }

    @Test
    public void getResourceByIdNotFound()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec404());
        given()
                .when()
                .get("api/unknown/23")
                .then().log().all();
    }

    @Test
    public void createUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec201());
        User user = new User("morpheus","leader");
        CreateUserResponse response = given()
                .body(user)
                .post("api/users")
                .then().log().all()
                .extract().body().as(CreateUserResponse.class);
        Assert.assertNotNull(response.getId());
        Assert.assertNotNull(response.getName());
        Assert.assertNotNull(response.getJob());
        Assert.assertNotNull(response.getCreatedAt());
    }

    @Test
    public void updateUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        User user = new User("morpheus","zion resident");
        UpdateUserResponse response = given()
                .body(user)
                .put("api/users/2")
                .then().log().all()
                .extract().body().as(UpdateUserResponse.class);
        Assert.assertNotNull(response.getName());
        Assert.assertNotNull(response.getJob());
        Assert.assertNotNull(response.getUpdatedAt());
    }

    @Test
    public void deleteUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec204());
        given()
        .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void successfulReg()
    {
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        SuccessfulReg reg = new SuccessfulReg("eve.holt@reqres.in","pistol");
        SuccessfulRegResponse response = given()
                .body(reg)
                .post("api/register")
                .then().log().all()
                .extract().body().as(SuccessfulRegResponse.class);
        Assert.assertEquals(response.getId(), id);
        Assert.assertEquals(response.getToken(), token);
    }

    @Test
    public  void unSuccessfulReg()
    {
        String error = "Missing password";
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec400());
        UnSuccessfulReg reg = new UnSuccessfulReg("sydney@fife");
        UnSuccessfulRegResponse response = given()
                .body(reg)
                .post("api/register")
                .then().log().all()
                .extract().body().as(UnSuccessfulRegResponse.class);
        Assert.assertEquals(response.getError(), error);
    }


}
