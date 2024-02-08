package topic_TestNGExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test7_VP_Checkpoint1 {
	public WebDriver driver;

//TC 1: Launch Chrome Browser
@Test
public void setup() {
	WebDriverManager.chromiumdriver().setup();
	driver = new ChromeDriver();
}

//TC 2: Go to Test Url
@Test(priority=1)
 public void gotoURL() {
	 driver.get("https://www.saucedemo.com/v1/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
// TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 }

//TC 4: Fill Username Textbox with input
@Test (priority=2)
  public void type_UserName() throws InterruptedException {
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    Thread.sleep(3000);
  }

//TC 5: Fill password Textbox with input
@Test(priority = 3)

 public void type_Password() throws InterruptedException {
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	Thread.sleep(3000);
 }

//TC 6: Click on Login Button
@Test(priority=4)
 public void click_Login() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    Thread.sleep(3000);
 }

//TC 7: Verify Login 
@Test(priority=5)
  	public void verifySDLogin() throws InterruptedException{
	     //refer the internal elements as a checkpoint
	     boolean elementPresence = driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed();
	     System.out.println(elementPresence);
	     if(elementPresence==true) {
	    	 System.out.println("Test Passed - Login successfully!");
	     }else {
	    	 System.out.println("Test Failed - Login Failed");
	     }
}

//TC 8: Close the Browser 
@Test(priority=6)
 public void teardown() {
    driver.close();	
 }
}
