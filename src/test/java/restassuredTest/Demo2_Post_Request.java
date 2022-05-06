package restassuredTest;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_Post_Request {
	public static HashMap map = new HashMap();
	 
	@BeforeClass
	public void postdata() {
		map.put("name",RestUtils.getName());
		map.put("job", RestUtils.getJob());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	@Test
	public void TestData() {
		
		given()
		      .contentType("application/json; charset=utf-8")
		      .body(map)
	   .when()
	         .post()
	   .then()
	         .statusCode(201)
	         .body("id",equalTo("321")
	         .body("createdAt",equalTo("2022-04-27T06:21:17.599Z"));
	        		   
	}
}
