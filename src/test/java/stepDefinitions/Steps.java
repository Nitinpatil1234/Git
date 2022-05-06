package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	   lp =new LoginPage(driver); 
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	   lp.setUserName(email);
	   lp.setPassword(password);
	}

	@When("click on login")
	public void click_on_login() {
	  lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
		
			Assert.assertTrue(false);
			}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
		
		driver.getTitle();
	   
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(2000);
	   
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	 
	}


}
