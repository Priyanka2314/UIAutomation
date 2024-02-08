package webdriver_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Test14_AbsoluteXPath {

	public static void main(String[] args) throws InterruptedException {
// TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//TC2: Goto Test URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		Thread.sleep(3000);
//TC3: Click on Create new account Button
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/a[1]")).click();
		Thread.sleep(3000);
//TC4: Fill FirstName Textbox with input
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
//TC5: Fill LastName Textbox with input
		driver.findElement(By.name("lastname")).sendKeys("Singh");
//TC6: Fill EmailAddress Textbox with input
		driver.findElement(By.name("reg_email__")).sendKeys("abcd@123");
//TC7: Fill New password  Textbox with input
//		driver.findElement(By.id("password_step_input")).sendKeys("p@1233");
//TC8: Select Day from Day DropDown
		Select day = new Select(driver.findElement(By.name("birthday_day")));
		//day.selectByValue("15");
		day.selectByIndex(28);
		Thread.sleep(3000);
		
//	TC: Close the Active Browser Window	
		driver.close();
	}

}
