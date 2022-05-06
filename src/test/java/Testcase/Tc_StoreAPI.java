package Testcase;
import org.apache.groovy.json.internal.JsonStringDecoder;
import org.testng.Assert;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

@Test(priority = 1)
public class Tc_StoreAPI {
	
	public void test_Returnsamapofstatuscodestoquantities(){
		
      given()
      .when()
            .get("https://petstore.swagger.io/v2/store/inventory")
      .then()
           .statusCode(200)
           .body("sold", equalTo("1"))
           .body("string", equalTo("292"));
		
	}

@Test(priority = 2)

public void test_ListOfUserObject() {
	
	HashMap map = new HashMap();
	
	map.put("id","2");
	map.put("username", "string");
	map.put("firstName", "string");
	map.put("lastName", "string");
	map.put("email", "string");
	map.put("password", "string");
	map.put("phone", "string");
	map.put("userstatus", "0");
	
	Response res=
	given()
	     .contentType("application/jason")
	     .body(map)
	.when()
	     .post("https://petstore.swagger.io/v2/user/createWithList")
	.then() 
	     .statusCode(200)
	     .log().body()
	     .extract().response();

	String jasonString=res.asString();   //Conversion of jason format in to String
	Assert.assertEquals(jasonString.contains("successful operation"), true);
		
}

public void test_PutRequest() {
	
HashMap map = new HashMap();
	
	map.put("id","2");
	map.put("username", "nitin");
	map.put("firstName", "string");
	map.put("lastName", "string");
	map.put("email", "string");
	map.put("password", "string");
	map.put("phone", "string");
	map.put("userstatus", "0");
	

	given()
	     .contentType("application/jason")
	     .body(map)
	.when()
	     .post("https://petstore.swagger.io/v2/user/createWithList")
	.then() 
	     .statusCode(200)
	     .log().body()
	     .body("id", equalTo("2"));
	
}

public void test_DeleteRequest() {
	
	Response response=
	given()
    .when()
          .get("https://petstore.swagger.io/v2/store/order/2")
    .then()
         .statusCode(200)
         .log().body()
         .extract().response();
	
	String responseString=response.asString();
	Assert.assertEquals(responseString.contains("Invalid ID supplied"), true);
}



}
