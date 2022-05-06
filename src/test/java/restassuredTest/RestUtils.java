
package restassuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("morpheus"+generatedString);
	}
	
	public static String getJob() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("leader"+generatedString);
	}
	
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return(generatedString+"reqres.in");
	}
	
	public static String getFirstname() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return(generatedString);
		
	}
	
	public static String getLastname() {
		String generatedString= RandomStringUtils.randomAlphabetic(3);
		return(generatedString);
	}

}
