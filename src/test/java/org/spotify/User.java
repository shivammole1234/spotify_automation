package org.spotify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class User {

    String token = "BQDAnhP3U9D46iBW74lmZ6AYFhALw9XnXyUfMoz61wrlSUBt_h-0HY5rr4Q9j_xXIOCn0t01aVWEnFEp8r6SsLlVvKoNBfGGcDNiyy2dqdJYB4rrKuWobbc7nv8140tLKGfbJXWI9dZ2tNYEWGwXMssPGqiLE2FGgvFiCun7fL23VV2-m9IX5w3LbBTwd0pc0Kzbiihd2JIjxyTaKj6qVOCpQ529IWdf9dfyvFJvtJYF7Tz1R1UKqp6kJsG2vSEkGWqftQJ9Q31hexm7q9bCiTuhtkxwcdkLefs8FZrGsfdEKr7cn1YLFvn3nbcArW0utJn5CHcDTNubha-om6p9BDs";
    @Test
    public void token() {
        Response res = RestAssured.given()

                .queryParam("response_type", "token")
                .queryParam("client_id", "0bf9ff380c444cfeb57a84fbb2d6dcdc")
                .queryParam("scope", "user-read-private,user-read-email,user-follow-modify,user-library-modify,user-library-read,playlist-modify-public,playlist-modify-private,ugc-image-upload,playlist-read-collaborative,playlist-read-private,playlist-modify-public,playlist-modify-private,user-read-playback-position")
                .queryParam("redirect_url", "http://localhost:3232")
                .queryParam("state", "State")
                .when()
                .post("https://accounts.spotify.com/authorize");
        res.prettyPrint();

    }

    @Test
    public void get_current_user() {

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");

        response.then().assertThat().statusCode(200);
        response.prettyPeek();

    }

    @Test
    public void get_user_top_item() {
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");

        response.then().assertThat().statusCode(200);
        response.prettyPeek();
    }

    @Test
    public void get_user_profile(){
        String user_id="31v5vu65lmgqpp2d3pjgaoidnmbi";
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/"+user_id);

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public  void follow_playlist(){

        String playlist_id="1CltEbijf5vPNUm3ganMNv";

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .put("https://api.spotify.com/v1/playlists/"+ playlist_id+"/followers");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public  void unfollow_playlist(){
        String playlist_id="1CltEbijf5vPNUm3ganMNv";

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/"+playlist_id+"/followers");

        response.prettyPeek();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void follow_artist(){
        String artist_id="4YRxDV8wJFPHPTeXepOstw";

        Response response=RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids",artist_id)
                .queryParam("type","artist")

                .when()
                .put("https://api.spotify.com/v1/me/following");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
    }

    @Test
    public void unfollow_artist(){
        String artist_id="4YRxDV8wJFPHPTeXepOstw";

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .queryParam("ids",artist_id)
                .queryParam("type","artist")
                .when()
                .delete("https://api.spotify.com/v1/me/following");

        response.then().assertThat().statusCode(204);
        response.prettyPrint();
    }
}