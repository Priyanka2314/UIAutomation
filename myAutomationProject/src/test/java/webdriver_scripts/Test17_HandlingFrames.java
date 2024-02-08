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

public class Test17_HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
//	 TC2: Goto Test URL
		driver.get("https://demoqa.com/nestedframes");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		Thread.sleep(3000);
//  TC4: Switch to Parent frame
		driver.switchTo().frame("frame1");
		Thread.sleep(3000);
//	TC 5: get text from Parent frame into console
		String parentFrametext=driver.findElement(By.xpath("//*[text()='Parent frame']")).getText();
		System.out.println(parentFrametext);
		Thread.sleep(3000);
//	TC 6:Switch to Child frame
		driver.switchTo().frame(0);
		Thread.sleep(3000);
//  TC 7: get text from child frame into console
		String childFrameptext=driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText();
		System.out.println(childFrameptext);
		Thread.sleep(3000);
	
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
