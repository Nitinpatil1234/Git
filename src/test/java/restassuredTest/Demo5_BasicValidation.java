package restassuredTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
public class Demo5_BasicValidation {
	
	// 1) Validate Test Status Code
	
	@Test(priority = 1)
	public void testStatusCode() {
		
		given()
	    .when()
	         .get("https://reqres.in/api/users/2")
	    .then()
	         .statusCode(200)
		     .log().all();    // Returns all Data body & response of Get method
	}



  // 2)Log Response same like above

// 3) Verifying single content in response body

	@Test(priority = 2)
public void singleContentResponse() {
	
	given()
	.when()
	     .get("https://reqres.in/api/users/2")
	.then()
	     .statusCode(200)
	     .body("data.first_name",equalTo("Janet"));  //This method used to verifying single content in Response body
	    }

// 4) Verifying multiple content in response body

public void multipleContentResponse() {
	
	given()
	.when()
	     .get("https://reqres.in/api/users?page=2")
	.then()
	     .statusCode(200)
	     .body("first_name",hasItems("Michael","Lindsay","Tobias"));
}

// In 3) we used equalTo method for finding single content from response
//In 4) we used hasItems method for finding Multiple content from response

public void setParamAndHeaders() {
	
// Set Parameters & headers 
	
	given()
	      .param("My Name", "Nitin")
	      .header("mYheader","Indian")
	.when()
	      .get("https://reqres.in/api/users/2")
	.then()
	      .statusCode(200)
	      .log().all();
}











}










