package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Deserialization {
    @Test
    public void deserializationTest(){
       // https://petstore.swagger.io/v2/pet/10567


       //we sent API GET request.
        Response response=RestAssured.given()
                .header("Accept","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/10567")  // providing URL
                .then().statusCode(200).extract().response();  //quick validation of status code.
        // extract().response() and store the data type in Response.//
        // response is a veriable
        //we are using as method for deserialization

        //deserialization
        //Coverting the Json to Java to access the key , value to do the validation by as method!!!! we use new TypeRef class!!!
        //as method yapiyor jsondan javaya transferi
        Map<String, Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });
        System.out.println(deserializedResponse);

        //validating pat id:
        Assert.assertEquals(10567,deserializedResponse.get("id"));

        //How to validate the name? how to retrieve it?
        //validating pat name:
        String actualPetName=String.valueOf(deserializedResponse.get("name")); // buradaki data type ilk bastaki olacak. exactly same at the beginning!!!
        Assert.assertEquals("hatiko",actualPetName);


        Map<String, Object> categoryMap= (Map<String, Object>) deserializedResponse.get("category"); //***get is now Object and we cant use it Map.
        // to be able to use it we need to CAST it!!! oTHERWISE WEW ILL GET ClassCastException.

        System.out.println(("Catogory Map : "+ categoryMap));






    }
}
