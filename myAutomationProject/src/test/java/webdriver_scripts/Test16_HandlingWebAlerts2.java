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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test16_HandlingWebAlerts2 {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		WebDriver driver = new EdgeDriver();
//	 TC2: Goto Test URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		Thread.sleep(3000);
//	TC4: To perform an operation an element which is inside a frame, we have switch into that frame
		driver.switchTo().frame(1);
//  TC5: Click on the Button alert
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
//  TC6: Send text to alert
		driver.switchTo().alert().sendKeys("Priyanka");
		Thread.sleep(3000);
//	TC 7: Accept the alert
		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
//	TC8: Get the plain text into console
     String getText=driver.findElement(By.id("demo")).getText();
     System.out.println(getText);
	Thread.sleep(3000);
//	TC9: Close the Active Browser Window 
		driver.close();
	}

}
