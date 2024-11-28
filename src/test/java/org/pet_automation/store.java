package org.pet_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class store {

    @Test
    public void add_order_in_store()
    {
        Response response= RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 11,\n" +
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2024-11-26T10:15:33.604Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");

        response.prettyPeek();
    }

    @Test
    public void find_order_by_id(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .post("https://petstore.swagger.io/v2/store/order/1");

        response.prettyPeek();
    }

    @Test
    public void return_pet_inv(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");

        response.prettyPeek();

    }

    @Test
    public  void delete_by_id(){
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/11");

        response.prettyPeek();
    }
}
