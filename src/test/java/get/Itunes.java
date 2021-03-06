package get;

import io.restassured.RestAssured;
import org.junit.Test;

public class Itunes {
    @Test
    public void itunesTest1(){
        /*
        1. Define/find a valid/coreect URL to send an HTTP request to
        2. Define a proper HTTP Method
        3. Define query string parameters (IF NEEDED)  -> optional
        4. Define header parameters
        5. Send/Execute a request
         */
        // https://itunes.apple.com/search

        RestAssured.baseURI="https://itunes.apple.com/search";  // this is just assignment. It is reassignment
        RestAssured.given().header("Accept","application/json")   //prerequisite
                .queryParam("term","michael+jackson")
                .queryParam("limit","1")
                .when().get()   //action
                .then().statusCode(200); // validation





    }




}
