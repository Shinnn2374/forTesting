package api;

import io.restassured.http.ContentType;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class reqresTest
{
    private static final String BASE_URL = "https://reqres.in";
    private static final String USER = "/api/users?page=2";

    @Test
    public void checkAvatarAndIdTest()
    {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(BASE_URL + USER)
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(o -> Assert.assertTrue(o.getAvatar().contains(o.getId().toString())));
    }
}
