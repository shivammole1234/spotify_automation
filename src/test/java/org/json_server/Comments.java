package org.json_server;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Comments {

    @Test
    public void post_comments(){
        Response response = RestAssured
                .given()
                .body("  {\n" +
                        "        \"id\": \"3\",\n" +
                        "        \"body\": \"good\",\n" +
                        "        \"postId\":3\n" +
                        "        \n" +
                        "    }")
                .when()
                .post("http://localhost:3000/comments");

        response.prettyPeek();
    }

    @Test
    public void get_comments(){
        Response response=RestAssured
                .given()
                .when()
                .get("http://localhost:3000/comments");

        response.prettyPeek();
    }

    @Test
    public void del_comments(){
        Response response = RestAssured
                .given()
                .when()
                .delete("http://localhost:3000/comments/3");

        response.prettyPeek();
    }

}
