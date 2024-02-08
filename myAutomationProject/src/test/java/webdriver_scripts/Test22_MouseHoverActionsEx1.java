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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

public class Test22_MouseHoverActionsEx1 {

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
//	TC 4: Click on fashion
		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
//		fashion.click();
		//Move Mouse towards fashion 
		Actions a = new Actions(driver);
		a.moveToElement(fashion).build().perform();
		Thread.sleep(3000);
//		Move Mouse towards  Women Ethnic 
		WebElement womenEthninc = driver.findElement(By.xpath("//a[text()='Women Ethnic']"));
		a.moveToElement(womenEthninc).build().perform();
		Thread.sleep(3000);
//		Click on Women Saree
		driver.findElement(By.xpath("//a[text()='Women Sarees']")).click();
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
