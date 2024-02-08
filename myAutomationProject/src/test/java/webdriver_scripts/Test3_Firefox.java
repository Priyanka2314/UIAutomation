/* Test Scenario 
  *************
  TC1: Launch the Edge Browser
  TC2: Goto Test URL
  TC3: Minimize Browser Window
  TC4: Maximize Browser Window
  TC5: Get the Title of the Page
  TC6: Get the Current URL of the Page
  TC7: Close the Browser */

package webdriver_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test3_Firefox {

	public static void main(String[] args) throws InterruptedException {
//   TC1: Launch the Chrome Browser
		System.setProperty("webdriver.gecko.driver", "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//	 TC2: Goto Test URL
		driver.get("https://www.selenium.dev/");
		
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC3: manage the browser window to minimized - Minimize Browser Window
		driver.manage().window().minimize();
		
		//Wait Time 3 sec 1sec=1000ms
				Thread.sleep(3000);
//	TC4: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//  TC5: Get the Title of the Page
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//	TC6: Get the Current URL of the Page
		String pageUrl=driver.getCurrentUrl();
		System.out.println(pageUrl);
		Thread.sleep(3000);
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
