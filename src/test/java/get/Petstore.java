package get;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Petstore {
    //Create anew test Method
    //Send a get request to "https://petstore.swagger.io/v2/pet/10567"
    //Validate response status code equals to 200

    @Test
    public void getPetStoreTest1() {

        RestAssured.baseURI = "https://petstore.swagger.io";  // this is just assignment. It is reassignment
        RestAssured.basePath= "v2/pet/10567";
        RestAssured.given()
                .header("Accept", "application/json") .log().all()  // if we put it after header it will print the REQUEST
                .when()
                .get()   //action
                .then()
                .statusCode(404); // validation  // !!!!!we can put .log().all() to print the same thing from postman


    }

}
