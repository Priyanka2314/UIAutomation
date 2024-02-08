package topic_TestNGExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test7_VP_Checkpoint6 {
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
	 driver.get("https://www.selenium.dev/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
// TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
 }

//TC 7: Verify Login 
@Test(priority=2)
  	public void verifySeleniumPage() throws InterruptedException{	  
	     String expectedText="Selenium automates browsers. That's it!";
	     String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Selenium automates')]")).getText();
	     System.out.println(expectedText);
	     if(actualText.contains(expectedText)) {
	    	 System.out.println("Test Passed - Launched Selenium Page");
	     }else {
	    	 System.out.println("Test Failed -  Launched some other Page");
	     }
}

//TC 8: Close the Browser 
@Test(priority=3)
 public void teardown() {
    driver.close();	
 }
}
