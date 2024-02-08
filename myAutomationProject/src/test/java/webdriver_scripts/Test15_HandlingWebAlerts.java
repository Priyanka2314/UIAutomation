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

public class Test15_HandlingWebAlerts {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		WebDriver driver = new EdgeDriver();
//	 TC2: Goto Test URL
		driver.get("https://www.jquery-az.com/javascript/demo.php?ex=151.1_1");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		Thread.sleep(3000);
//  TC4: Click on the Button alert
		driver.findElement(By.xpath("//button[text()='Click here to show confirm alert']")).click();
//		Thread.sleep(3000);
//  TC5: Get the plain text from alert1 into console 
		String ptext1=driver.switchTo().alert().getText();
		System.out.println(ptext1);
//	TC 6: Dismiss the alert
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
//	TC7: Get the plain text from alert1 into console
		String ptext2=driver.switchTo().alert().getText();
		System.out.println(ptext2);
//	TC 8: Accept the alert
			driver.switchTo().alert().accept();
//			Thread.sleep(3000);
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
