package restassuredTest;

import java.util.HashMap;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_Put_Request {
	
	public static HashMap map=new HashMap();
	
	String emailString = RestUtils.getEmail();
	String firstNameString = RestUtils.getFirstname();
	String lastNameString = RestUtils.getLastname();
	
	@BeforeClass
	public void putData() {
		map.put("email", emailString);
		map.put("first_name", firstNameString);
		map.put("last_name", lastNameString);
		int id = 2; 
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.basePath = "/2";
		}
	@Test
	public static void testPUT() {
		
		given()
		      .contentType("application/json")
		      .body(map)
		.when()
		      .put()
		.then()
		      .statusCode(200);
		  
	}

}
