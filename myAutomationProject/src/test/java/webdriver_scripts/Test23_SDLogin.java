package webdriver_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test23_SDLogin {

	public static void main(String[] args) throws InterruptedException {
 //TC 1: Launch Chrom Browser
		WebDriver driver = new ChromeDriver();
 // TC 2: Go to Test Url
	    driver.get("https://www.saucedemo.com/v1/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 // TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 // TC 4: Fill Username Textbox with input
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    Thread.sleep(3000);
 // TC 5: Fill password Textbox with input
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    Thread.sleep(3000);
 // TC 6: Click on Login Button
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    Thread.sleep(3000);
 //TC 7: Verify Login 
	     String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
	     String actualUrl = driver.getCurrentUrl();
	     if(actualUrl.equals(expectedUrl)) {
	    	 System.out.println("Test Passed - Login successfully!");
	     }else {
	    	 System.out.println("Test Failed - Login Failed");
	     }
 //TC 8: Close the Browser 
	     driver.close();
	    

	}

}
