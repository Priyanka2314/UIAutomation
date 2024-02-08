/* Test Scenario 
  *************
  TC1: Launch the Chrome Browser
  TC2: Goto Test URL
  TC3: Minimize Browser Window
  TC4: Maximize Browser Window
  TC5: Get the Title of the Page
  TC6: Get the Current URL of the Page
  TC7: Close the Browser */

package webdriver_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Test22_SearchBoxActionsEx6 {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//	 TC2: Goto Test URL
		driver.get("https://www.flipkart.com/");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//	Close Login
		driver.findElement(By.xpath("//label[contains(text(),'Enter Email/Mobile number')]/preceding::*[6]")).click();
//	TC 4: Click on Search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		//Move Mouse towards fashion 
		Actions a = new Actions(driver);
		a.click(searchBox).sendKeys("smartphones").build().perform();
		Thread.sleep(3000);
		a.click().sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.click().sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.click().sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(3000);
		a.click().sendKeys(Keys.ENTER).build().perform();
		WebElement element= new WebDriverWait(driver, Duration.ofSeconds(5)).
				     until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Cart']")));
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
