package ru.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void shouldEchoPostedData() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestData = "some data";

        given()
                .contentType("text/plain; charset=UTF-8")
                .body(requestData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("broken data for ci check"));
    }
}
