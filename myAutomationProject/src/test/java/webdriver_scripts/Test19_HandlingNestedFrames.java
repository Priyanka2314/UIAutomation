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

public class Test19_HandlingNestedFrames {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
//	 TC2: Goto Test URL
		driver.get("https://demoqa.com/frames");
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		Thread.sleep(3000);
//  TC4: Switch into 0th-frame from TopWindow
		driver.switchTo().frame("frame1");
		Thread.sleep(3000);
//	TC 5: get text from 0th frame into console
		String ptext=driver.findElement(By.xpath("(//h1[text()='This is a sample page'])[1]")).getText();
		System.out.println(ptext);
		Thread.sleep(3000);
//	TC 6:Get text from 1st frame
		//Switch from 0th frame to 1st frame
		//To switch from one frame to another frame,first we have to switch to default content(i.e. Top window)
		driver.switchTo().defaultContent();
		//then switch from 0th frame to 1st frame
		driver.switchTo().frame("frame2");
		Thread.sleep(3000);
//  TC 7: get text from 1sth frame into console
		String secondFrameptext=driver.findElement(By.xpath("(//h1[text()='This is a sample page'])[1]")).getText();
		System.out.println(secondFrameptext);
		Thread.sleep(3000);
	
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
