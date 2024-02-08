/* Test Case: Automate creating a new Tab 
  *************
  TC1: Launch the Chrome Browser
  TC2: Goto Test URL https://www.amazon.in/
  TC3: Manage the browser window to be maximized
  TC4: Create a new Tab
  TC6: Reload Current Active Page
  TC7: Close the Active Browser Window*/

package webdriver_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test5_NewTab {

	public static void main(String[] args) throws InterruptedException {
//		TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		
//	    TC2: Goto Test URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		//Wait time
		Thread.sleep(3000);
		
//		TC3: Manage the browser window to be maximized
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
//		TC4: Create a new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.navigate().to("https://www.google.com/");
		
	/*	// TC7: Close the Active Browser Window/Tab
		driver.close();
		*/
//		Quit the Entire Browser session
		driver.quit();

	}

}
