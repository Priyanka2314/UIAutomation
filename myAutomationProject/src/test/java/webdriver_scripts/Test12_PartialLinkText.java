package webdriver_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Test12_PartialLinkText {

	public static void main(String[] args) throws InterruptedException {
// TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//TC2: Goto Test URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		Thread.sleep(3000);
//TC3: Click on Create new account Button
//		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.partialLinkText("Create new")).click();
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
//TC9: Select Month from Month DropDown
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("10");
		Thread.sleep(3000);
		
//TC10: Select Year from Year DropDown
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2022");
		Thread.sleep(3000);
//TC11: Click on Radio button
		//below()
		By maleRB=RelativeLocator.with(By.tagName("input")).below(By.id("month"));
		driver.findElement(maleRB).click();
		Thread.sleep(3000);
		
		//above()
		By pwdtbox = RelativeLocator.with(By.tagName("input")).above(By.id("month"));
		driver.findElement(pwdtbox).sendKeys("p@123");
		Thread.sleep(3000);
		
		//toLeftOf()
		By fmRB=RelativeLocator.with(By.tagName("input")).toLeftOf(maleRB);
		driver.findElement(fmRB).click();
		Thread.sleep(3000);
		
		//toRightOf()
	/*	By custRB= RelativeLocator.with(By.tagName("input")).toRightOf(maleRB);
		driver.findElement(custRB).click();
		Thread.sleep(3000);
		*/
		
		//near()
		By text=RelativeLocator.with(By.tagName("p")).near(maleRB);
		String ptext=driver.findElement(text).getText();
		System.out.println(ptext);
		Thread.sleep(3000);
		
//	TC: Close the Active Browser Window	
		driver.close();
	}

}
