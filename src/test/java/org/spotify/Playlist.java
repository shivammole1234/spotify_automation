package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Playlist {

    String token ="BQDnTV7ZHGgejIPHUpQ8TQdpYTwNK6tudce-aVybV-96OWw8XwKLno6JkocFmhpuiomBxS9q4EchQn7aMpVOm79QJUGXZdgU7OBtxvJvDUrMzqMkwpMq5oK5WtpBhQvlI9c9apzzv8UUjVjZWotJk1YK7hdy4ENzYJMCjEBXxxAfcTMKmUSwa2tGWZAfl6RHmK63OXdQMzUQEYZCB67t0mvyIVdwX9A6U1IFvFS1BEmSrbbUe58FaFABU3biXgt1pHP2jR-QY07MLcGSqwRp4eWOOIzo0KBl7q5NC6Y8AKCsZN4BEX_sZst4SqJ2qyDEAOwqmbuR-oRy_AOxVwdsKOc";
    @Test
    public void get_playlist(){
        String playlist_id="4z5whwZPQuMotubMwwlsLB";
        Response response=RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("response_type", "token")
                .queryParam("id",playlist_id)
                .queryParam("client_id", "0bf9ff380c444cfeb57a84fbb2d6dcdc")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "State")
                .when()
                .get("https://api.spotify.com/v1/playlists/"+playlist_id);

        response.then().assertThat().statusCode(200);
        response.prettyPrint();

    }


}
