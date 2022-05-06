package restassuredTest;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo1_Get_Request {
	 
	public void listUser(){
		
		given()
		.when()
		    .get("https://reqres.in/api/users?page=2")
		.then()
		     .statusCode(200)
		     .statusLine("HTTP/1.1 200 ok")
		     .assertThat().body("email", equalTo("michael.lawson@reqres.in"))
		     .header("content-Type", "application/json; charset=utf-8");
		
	}

}
 
//Here . used for when contains get like that
