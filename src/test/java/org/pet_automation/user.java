package org.pet_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class pet_store {

    @Test
    public void user(){
    Response response = RestAssured
            .given()
            .header("accept", "application/json")
            .header("Content-Type", "application/json")
            .body("{\n" +
                    "  \"id\": 0,\n" +
                    "  \"username\": \"shivam2\",\n" +
                    "  \"firstName\": \"shivam\",\n" +
                    "  \"lastName\": \"mole\",\n" +
                    "  \"email\": \"shivam1712@gmail.com\",\n" +
                    "  \"password\": \"shivam_019\",\n" +
                    "  \"phone\": \"09887654321\",\n" +
                    "  \"userStatus\": \n" +
                    "}")
            .when()
            .post("https://petstore.swagger.io/v2/user");

    response.prettyPeek();
}

@Test
public void user_login(){
        Response response =RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=shivam&password=shivam_p");

        response.prettyPeek();

}
@Test
public void get_user(){
        Response response =RestAssured
            .given()
            .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
            .get("https://petstore.swagger.io/v2/user/shivam");

        response.prettyPeek();
}

@Test
    public void update_user(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("" +
                        "{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"shivam2\",\n" +
                        "  \"firstName\": \"shivam\",\n" +
                        "  \"lastName\": \"mole\",\n" +
                        "  \"email\": \"shivam1712@gmail.com\",\n" +
                        "  \"password\": \"shivam_019\",\n" +
                        "  \"phone\": \"09887654321\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/shivam");

        response.prettyPeek();
}

@Test
    public void del_user(){
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/shivam01");
        response.prettyPeek();

}
}
