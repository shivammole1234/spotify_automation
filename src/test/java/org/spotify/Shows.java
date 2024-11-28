package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Shows {
    String token ="BQDIgKN4GrKy_XnYXCTyRiCpWq2DYMBiY-gYymiuc63JQ6SPk-LGPRjnbXugI-joCqDp8OhHQzLqu7BhLS9KQKI65NB8qtLeZTKPtjbibee1ptAdopuGfai6k8b196ZZCLlPMpSbnY_dtF3qdgJrXuxr_dkjuCl2rA48iXi68CGX9R2JKltve7qY8OCg1rUBPKDj7uWs7KtKS_IGmTZGsJJdI8t7NGao9j_AUg75DNQb-yshfr_uLZsGeSW82acLVvnWEHcXWVZcAbTWb1MdMDhD89CDQBLYMNGWEvksszSASn94HRxKnzPKlEcGDHsx8XbFheFdCZdAHnfh216qd8A";

    @Test
    public void get_shows(){
        String show_id="6ZcvVBPQ2ToLXEWVbaw59P";

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("response_type", "token")
                .queryParam("id",show_id)
                .queryParam("client_id", "0bf9ff380c444cfeb57a84fbb2d6dcdc")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "State")
                .when()
                .get("https://api.spotify.com/v1/shows/"+show_id);

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void save_shows_for_curr_user(){

        String show_id="6ZcvVBPQ2ToLXEWVbaw59P";
        Response response =RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("response_type", "token")
                .queryParam("id",show_id)
                .queryParam("client_id", "0bf9ff380c444cfeb57a84fbb2d6dcdc")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "State")
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids="+show_id);

        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void remove_user_saved_show(){
        String show_id="6ZcvVBPQ2ToLXEWVbaw59P";
        Response response =RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("response_type", "token")
                .queryParam("id",show_id)
                .queryParam("client_id", "0bf9ff380c444cfeb57a84fbb2d6dcdc")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "State")
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids="+show_id);

        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }
}
