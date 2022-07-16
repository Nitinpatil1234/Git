package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils1;

public class StepDefination extends Utils1 {
	RequestSpecification response;
	ResponseSpecification res;
	Response respo;
    static String place_id;
	
	TestDataBuild data=new TestDataBuild();

	

@Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String name, String language, String address) throws IOException {
	   
	     response = given().spec(requestSpecification())
		.body(data.addPlacePayload(name,language,address)); 
		
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
    	//Constructor will be called with value of resources
		    APIResources resourceAPI= APIResources.valueOf(resource);
		   System.out.println(resourceAPI.getResource()); 
		   
		   if(method.equalsIgnoreCase("Post"))
		         respo=response.when().post(resourceAPI.getResource());
		   else if (method.equalsIgnoreCase("Get"))
			   respo=response.when().get(resourceAPI.getResource());
			
		
	  
	}
	@Then("The API call got is success with status code {int}")
	public void the_api_call_got_is_success_with_status_code(Integer int1) {
		
		assertEquals(respo.getStatusCode(),200);
	  
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
		
		
	  assertEquals(getJsonpath(respo, keyvalue),Expectedvalue);
		
	}
	
	@Then("verify  place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    
		  place_id=getJsonpath(respo, "place_id");
		 response =given().spec(requestSpecification()).queryParam("place_id", place_id);
		 user_calls_with_http_request(resource, "Get");
		
		 String actualName=getJsonpath(respo, "name");
		 assertEquals(actualName, expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	  
		response=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
		
		
	}
}
