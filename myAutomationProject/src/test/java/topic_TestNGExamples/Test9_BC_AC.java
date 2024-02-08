package topic_TestNGExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test9_BC_AC {
	public WebDriver driver;

//TC 1: Launch Chrome Browser
@BeforeClass
public void setup() {
	WebDriverManager.chromiumdriver().setup();
	driver = new ChromeDriver();
}

//TC 2: Go to Test Url
@Test(priority=1)
 public void gotoSeleniumURL() throws InterruptedException {
	 driver.get("https://www.selenium.dev/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
// TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    String expectedText="Selenium automates browsers. That's it!";
	     String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Selenium automates')]")).getText();
	     System.out.println(expectedText);
//	     if(actualText.contains(expectedText)) {
//	    	 System.out.println("Test Passed - Launched Selenium Page");
//	     }else {
//	    	 System.out.println("Test Failed -  Launched some other Page");
//	     }
	     Assert.assertEquals(actualText, expectedText);
	     Thread.sleep(5000);
 }

//TC 3:
@Test(priority=2)
public void gotoSauceDemoURL() throws InterruptedException {
	 driver.get("https://www.saucedemo.com/v1/index.html");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    String expectedTittle="Swag Labs";
	     String actualTittle = driver.getTitle();
	     System.out.println(expectedTittle);
	     Assert.assertEquals(actualTittle, expectedTittle);
	     Thread.sleep(5000);
}

//TC 4:
@Test(priority=3)
public void gotoBhanuSaiURL() throws InterruptedException {
	 driver.get("https://bhanusaii.wordpress.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	    String expectedTittle="Bhanu Sai – “Learning gives creativity Creativity leads to thinking Thinking provides knowledge Knowledge makes you great.”";
	     String actualTittle = driver.getTitle();
	     System.out.println(expectedTittle);
	     Assert.assertEquals(actualTittle, expectedTittle);
	     Thread.sleep(5000);
}

//TC 5: Close the Browser 
@AfterClass
 public void teardown() {
    driver.close();	
 }
}
