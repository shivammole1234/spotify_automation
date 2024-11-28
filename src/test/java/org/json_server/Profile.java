package org.json_server;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Profile{

    @Test
    public void create_profile(){
        Response response = RestAssured
                .given()
                .when()
                .body("" + "{\n" + "    \"name\": \"typicode\"\n" + "}")
                .post("http://localhost:3000/profile");

        response.prettyPeek();
    }

    @Test
    public void get_profile(){
        Response response = RestAssured
                .given()
                .when()
                .get("http://localhost:3000/profile");

        response.prettyPeek();
    }

}

