package com.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;
	
	@Given("user on login page")
	public void user_on_login_page() {
		System.out.println("Step:-user on login page ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	}

	@When("user enter (.*)and(.*)$")
	public void user_enter_username_and_password(String uname, String Psword) {
		System.out.println("Step 1:-user enter username and Password ");
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(Psword);
	   
	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Step 2:-click on login button ");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	    
	}

	@Then("login should land on home page")
	public void login_should_land_on_home_page() {
		System.out.println("Step 3:-login should land on home page ");
		driver.close();
		
		}
	@When("user enter credentails using datatable")
	public void user_enter_credentails_using_datatable(DataTable dataTable){
		List<List<String>>data = dataTable.cells();
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(data.get(0).get(1));
		
		
	    
	}}



