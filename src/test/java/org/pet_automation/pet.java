package org.pet_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class pet {

    @Test
    public void create_pet(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                                "  \"id\": 1,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 0,\n" +
                                "    \"name\": \"raja 01\"\n" +
                                "  },\n" +
                                "  \"name\": \"doggie\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"string\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 0,\n" +
                                "      \"name\": \"badshah\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}"
                )
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPeek();
    }

    @Test
    public void get_by_id(){
        Response response =RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/12405");

        response.prettyPeek();

    }

    @Test
    public void get_by_status(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")

                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        response.prettyPeek();

    }

    @Test
    public void update_pet_in_store(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1");

        response.prettyPeek();

    }

}
