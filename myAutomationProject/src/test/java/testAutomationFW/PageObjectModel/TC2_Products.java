package testAutomationFW.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC2_Products {
	static Page_Login login;
	static WebDriver driver;
  @Test
  public void verifySDLogin() throws InterruptedException {
	//TC 1: Launch Chrom Browser
		 driver = new ChromeDriver();
	 // TC 2: Go to Test Url
		    driver.get("https://www.saucedemo.com/v1/");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 // TC 3: manage the browser window to maximize -  Maximize Browser Window
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    
		    login=new Page_Login(driver);
		  //Fill Username Textbox with input
		    login.type_Username("standard_user");
		  // Fill password Textbox with input
		    login.type_UPassword("secret_sauce");
		  // Click on Login Button
		    login.click_Login();
		  //Verify Product text
		     String expectedtxt="Products";
		     String actualtxt = login.capture_Producttxt();
		    Assert.assertEquals(actualtxt, expectedtxt);
		  //Click on Add to Cart Button
		    login.click_AddtoCart();
		  //Click on shopping cart Button
		    login.click_shopping_cart();
		  //Verify Cart text
		    String expectedCartTxt="Your Cart";
		    String actualCartTxt=login.capture_text_Cart();
		    Assert.assertEquals(actualCartTxt, expectedCartTxt);
		    Thread.sleep(5000);
  }
  
  @AfterMethod
  public void teardown() {
	 driver.close();
  }
}
