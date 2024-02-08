package webdriver_scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class Test10_Tagname {

	public static void main(String[] args) throws InterruptedException {
// TC1: Launch the Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//TC2: Goto Test URL https://www.selenium.dev/
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		
		//Get no. of links and it's count
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
		for(int i=0;i<elements.size();i++) {
			System.out.println(elements.get(i).getText());
		}
		Thread.sleep(3000);
//	TC: Close the Active Browser Window	
		driver.close();
	}

}
