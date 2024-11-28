package org.json_server;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Posts {

    @Test
    public void create_Post(){
        Response response = RestAssured
                .given()
                .body("{\n" +
                        "    \"id\": \"66\",\n" +
                        "    \"title\": \"OS developer\",\n" +
                        "    \"author\": \"Mayur\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/posts");

        response.prettyPeek();
    }

    @Test
    public void get_post(){
        Response response = RestAssured
                .given()
                .when()
                .get("http://localhost:3000/posts");

        response.prettyPeek();

    }

    @Test
    public void update_post(){
        Response response =RestAssured
                .given()
                .body("\n" +
                        "    {\n" +
                        "        \"id\": \"3\",\n" +
                        "\n" +
                        "        \"author\": \"Mayur Chopde\"\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/posts/3");

        response.prettyPeek();
    }

    @Test
    public  void delete_post(){
        Response response =RestAssured
                .given()
                .when()
                .delete("http://localhost:3000/posts/2");

        response.prettyPeek();
    }

}
