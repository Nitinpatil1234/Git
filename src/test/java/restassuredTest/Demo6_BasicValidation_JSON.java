

//Verifying single content in XML response
//verifying multiple content in XML response
//Verifying the all the content in xml response in one go
//Find values by using Xml path in XML response
//Xpath with text() function




package restassuredTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpResponse.BodyHandler;

public class Demo6_BasicValidation_JSON {
	
	public void JsonValidation() {
	
	given()
	.when()
	     .get("https://reqres.in/api/users/2")
	.then()
	     .statusCode(200)
	     .body("email",equalTo("\"janet.weaver@reqres.in\""));
	      
}
	
	public void multipleJsonValidation() {
		
		given()
		.when()
		     .get("https://reqres.in/api/users/2")
		.then()
		     .statusCode(200)
		     .body("email", equalTo("janet.weaver@reqres.in"))
		     .body("first_name", equalTo ("Janet"))
		     .body("last_name", equalTo("Weaver"));
	}
	
	public void VerifyallContentinOne() {
		 
		given()
		.when()
		     .get("")
		.then()
		     .statusCode(200)
		     .body("name.text()",equalTo("JanetWeaver"));
	}
	
	//Find values by using Xml path in XML response
	
	public void testByUsingXMLPath() {
		
		given()
		.when()  
		     .get("https://reqres.in/api/users/2")
		.then()
		     .body(hasXPath("/data/email/",containsString("janet.weaver@reqres.in")));
		
	}
}