package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;


public class reqresTest
{
    private static final String BASE_URL = "https://reqres.in";
    private static final String USER = "/api/users?page=2";

    @Test
    public void checkAvatarAndIdTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get(USER)
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(o -> Assert.assertTrue(o.getAvatar().contains(o.getId().toString())));
    }

    @Test
    public void checkOnEmail()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get(USER)
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        Assert.assertTrue(users.stream().allMatch(o -> o.getEmail().endsWith("@reqres.in")));
    }

    @Test
    public void checkIdAndAvatar()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<UserData> users = given()
                .when()
                .get(USER)
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(o -> Assert.assertTrue(o.getAvatar().contains(o.getId().toString())));
    }

    @Test
    public void successRegister()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }
}

