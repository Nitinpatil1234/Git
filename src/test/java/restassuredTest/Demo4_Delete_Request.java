package restassuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class Demo4_Delete_Request {
	
	@Test
	public void deleteData() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.basePath="/delete/2";
		
		Response response=
		
		given()
		.when()
		      .delete()
		.then()
		      .statusCode(200)
		      .statusLine("HTTP/1.1 200 OK")
		      .log().all()
		.extract().response();
		
		String jsonAsString = response.asString();  // Here conversion of jason format into string 
		Assert.assertEquals(jsonAsString.contains("sucessfully! deleted Records"),true);
		
		    
	}
	
	

}
