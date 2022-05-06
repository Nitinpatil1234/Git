package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	//Create LoginPage Constructor & pass driver
	public LoginPage(WebDriver rdriver) {
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}
	//PageFactory 
	@FindBy(id="Email")
	WebElement txtEmailElement;
	
	@FindBy(id="Password")
	WebElement txtPasswordElement;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	WebElement lnkLogoutElement;
	
	//Actions
	
	public void setUserName(String uname) {
		txtEmailElement.clear();
		txtEmailElement.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		txtPasswordElement.clear();
		txtEmailElement.sendKeys(pswd);
	}
	public void clickLogin() {
		btnLogin.click();
		}
	public void clickLogout() {
		lnkLogoutElement.click();
		}
	
	
	
	
	
}
