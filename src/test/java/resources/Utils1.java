package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import groovyjarjarpicocli.CommandLine.IFactory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils1 {
	
	public static  RequestSpecification req;

	//Keeping reusable Methods
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
	         
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	
	         req=new RequestSpecBuilder().setBaseUri(getGlobalData("baseUrl")).addQueryParam("key", "qaclick123")
	        		 .addFilter(RequestLoggingFilter.logRequestTo(log))
	        		 .addFilter(ResponseLoggingFilter.logResponseTo(log))
	        		 .setContentType(ContentType.JSON).build();
	                  return req;
                }
		return req;
	}
		
	public static String getGlobalData(String key) throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	                           //Response body,SCOPE  //rETURN app
	public String getJsonpath(Response respo, String key) {
		String respoString=respo.asString();
		JsonPath jsonPath=new JsonPath(respoString);
		
		return jsonPath.get(key).toString();
	}
}

