package get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class Deserialization {
    @Test
    public void deserializationTest(){
       // https://petstore.swagger.io/v2/pet/10567

        Response response=RestAssured.given()
                .header("Accept","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")
                .then().statusCode(200).extract().response();

    }
}
