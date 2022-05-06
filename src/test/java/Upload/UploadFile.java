package Upload;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	
	public static void main (String arg[]) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		 WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
//		Set<String> ele = driver.getWindowHandles();
		
		
		driver.navigate().to("https://www.monsterindia.com/");
		driver.findElement(By.id("1227")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"user-signup-actions\"]/div[1]/div[1]/a[2]/span[1]")).click();
		//driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\lenovo\\Documents\\Automation JD (Selenium with Java)_Coditas (1).pdf");
		
	}

}
