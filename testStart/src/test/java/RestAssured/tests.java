package RestAssured;

import RestAssured.pojos.ResourceData;
import RestAssured.pojos.UserData;
import com.codeborne.selenide.commands.As;
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

    


}
