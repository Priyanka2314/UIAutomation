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

public class Test22_DoubleClickActionsx2 {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//	 TC2: Goto Test URL
		driver.get("https://only-testing-blog.blogspot.com/2014/09/selectable.html");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//  TC4: perform Double click 
		WebElement doubleClickBtn=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions a = new Actions(driver);
		a.doubleClick(doubleClickBtn).build().perform();
		Thread.sleep(3000);
		String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		Thread.sleep(3000);
		//Accept alert
		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
		

//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
