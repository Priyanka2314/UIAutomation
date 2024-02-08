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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test21_JavaRobot {

	public static void main(String[] args) throws InterruptedException, AWTException {
//  TC 1: Launch the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//	TC 2: Goto Test URL
		driver.get("https://smallpdf.com/word-to-pdf");
		
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC 3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//	TC 4:
		//Implement Java Robot to Handle Window Alert
		Robot r =new Robot();
		//Scroll one step down
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		//Scroll one step to top
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		//Scroll to Bottom
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
		Thread.sleep(5000);
		//Scroll to Top
		r.keyPress(KeyEvent.VK_HOME);
		r.keyRelease(KeyEvent.VK_HOME);
		Thread.sleep(5000);
       //Open a new Tab
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//GoTo test URL
		driver.navigate().to("https://bhanusaii.wordpress.com/");
		//Close the Tab
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//Create a new Window
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
//	TC: Close the Active Browser Window 
		driver.quit();
	}

}
