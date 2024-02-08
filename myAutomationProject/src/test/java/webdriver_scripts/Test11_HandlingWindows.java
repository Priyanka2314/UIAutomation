package webdriver_scripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test11_HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//TC1: Launch Chrome browser 
		WebDriver driver = new ChromeDriver();
//TC2: Goto Test Url https://demoqa.com/browser-windows
		driver.get("https://demoqa.com/browser-windows");
		//wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
		//Maximize browser window
		driver.manage().window().maximize();
//		TC3: Click on new Tab button
		driver.findElement(By.id("windowButton")).click();
//		TC4: Handle Tabs
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);
		Thread.sleep(5000);
//		TC5: Switch from 0th tab to 1st tab
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(5000);
		//Get plain text to Console
		String ptext=driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(ptext);
//		TC6: close 1st Tab
		driver.close();
//		TC7: Switch from 0th tab to 1st tab
		driver.switchTo().window(tabs.get(0));
//		TC8: Close 0th Tab
		driver.close();
		

	}

}
