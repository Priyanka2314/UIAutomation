/* Test Case: Automate Browser Navigation 
  *************
  TC1: Launch the Chrome Browser
  TC2: Goto Test URL https://www.amazon.in/
  TC3: Navigate to URL https://www.flipkart.com/
  TC4: Navigate one step back to Amazon website
  TC5: Navigate one step forward to Flipkart website
  TC6: Reload Current Active Page
  TC7: Close the Active Browser Window*/

package webdriver_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4_BrowserNavigation {

	public static void main(String[] args) throws InterruptedException {
		// TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		//Launch the Edge Browser
		//WebDriver driver = new EdgeDriver();
		
		//Launch the Edge Browser
		//WebDriver driver = new FirefoxDriver();
		
		// TC2: Goto Test URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		//Wait time
		Thread.sleep(3000);
		
		// TC3: Navigate to URL https://www.flipkart.com/
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		// TC4: Navigate one step back to Amazon website
		driver.navigate().back();
		Thread.sleep(3000);
		
		// TC5: Navigate one step forward to Flipkart website
		driver.navigate().forward();
		Thread.sleep(3000);
		
		// TC6: Reload Current Active Page
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		// TC7: Close the Active Browser Window
		driver.close();

	}

}
