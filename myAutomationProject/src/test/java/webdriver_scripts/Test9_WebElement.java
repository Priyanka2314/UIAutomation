package webdriver_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Test9_WebElement {

	public static void main(String[] args) throws InterruptedException {
// TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//TC2: Goto Test URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		Thread.sleep(3000);
//TC3: Click on Create new account Button
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
		
//TC4: Perform multiple operation on same element
/*		//1.Fill FirstName Textbox with input
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
		Thread.sleep(3000);
		//2.Clear input from textbox
		driver.findElement(By.name("firstname")).clear();
		Thread.sleep(3000);
		//3.Fill FirstName Textbox with input
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
		Thread.sleep(3000);
*/
		WebElement fname = driver.findElement(By.name("firstname"));
		fname.sendKeys("Priyanka");
		Thread.sleep(3000);
		fname.clear();
		Thread.sleep(3000);
		fname.sendKeys("Anshu");
		Thread.sleep(3000);
		String fnameValue=fname.getAttribute("value");
		System.out.println(fnameValue);
		
//	TC: Close the Active Browser Window	
		driver.close();
	}

}
