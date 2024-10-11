package api;

import api.Users.UserData;
import api.data.ColorsData;
import api.reg.Register;
import api.reg.SuccessReg;
import api.reg.UnSuccessReg;
import api.register.Man;
import api.register.ManResponse;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;
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

    @Test
    public void unSuccessUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec400());
        Register user = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    public void sortedYearsTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        List<ColorsData> colorsData = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colorsData.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
    }

    @Test
    public void deleteUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void getSingleUserTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        UserData user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", UserData.class);
        Assert.assertNotNull(user);
    }

    @Test
    public void singleUserNotFoundTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpecUnique(404));
        given()
                .when()
                .get("api/users/23")
                .then().log().all();
    }

    @Test
    public void singleResourceTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpec200());
        ColorsData data = given()
                .when()
                .get("api/unknow/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", ColorsData.class);
        Assert.assertNotNull(data);
    }

    @Test
    public void singleResourceNotFoundTest()
    {
        Specification.installSpecification(Specification.requestSpec(BASE_URL), Specification.responseSpecUnique(404));
        given()
                .when()
                .get("api/unknow/23")
                .then().log().all();
    }

    
}

