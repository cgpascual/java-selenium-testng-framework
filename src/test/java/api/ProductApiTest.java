package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    @Test
    public void getAllProductsShouldReturn200() {
        Response response = given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertTrue(response.jsonPath().getList("$").size() > 0,
                "Product list should not be empty");
    }

    @Test
    public void getSingleProductShouldReturnCorrectId() {
        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", org.hamcrest.Matchers.equalTo(1));
    }
}