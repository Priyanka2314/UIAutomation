package topic_ITest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testrescontext_for_ControlParameter_1stWay {
	WebDriver driver;
  @BeforeMethod
  public void setup(ITestContext testcontext) {
	  System.out.println("Setup method");
	  String Browser=testcontext.getCurrentXmlTest().getParameter("browser");
	  if(Browser.equals("chrome")) {
		  driver=new ChromeDriver();
	  }else if(Browser.equals("firefox")) {
		  driver=new FirefoxDriver();
	  }else if(Browser.equals("edge")) {
		  driver = new EdgeDriver();
	  }
	  
  }
  
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
  @Test
  public void sdLogin() throws InterruptedException {
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
	     Assert.assertEquals(actualUrl, expectedUrl);
  }
}
