/* Test Scenario 
  *************
  TC1: Launch the Chrome Browser
  TC2: Goto Test URL
  TC3: Minimize Browser Window
  TC4: Maximize Browser Window
  TC5: Get the Title of the Page
  TC6: Get the Current URL of the Page
  TC7: Close the Browser */

package topic_Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.openqa.selenium.interactions.Actions;

public class Test4_Sikuli_MouseHover {

	public static void main(String[] args) throws InterruptedException, FindFailed {
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
//		driver.findElement(By.xpath("//label[contains(text(),'Enter Email/Mobile number')]/preceding::*[6]")).click();
//	TC 4: Click on fashion
//		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
		//Implementing Sikuli
		Screen s=new Screen();
		//Mousehover on Login In
		s.hover("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\flipkartMousehover_Locators\\Login_hover.png");
		Thread.sleep(3000);
		//Move Mouse towards fashion 
		s.hover("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\flipkartMousehover_Locators\\fashion_hover.png");
		Thread.sleep(3000);
		//Move Mouse towards Women Western 
		s.hover("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\flipkartMousehover_Locators\\Women Western_hover.png");
		Thread.sleep(3000);
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
