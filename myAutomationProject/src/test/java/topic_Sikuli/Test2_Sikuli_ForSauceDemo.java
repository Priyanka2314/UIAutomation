package topic_Sikuli;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Test2_Sikuli_ForSauceDemo {
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		//Launch the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Go to Test Url
		driver.get("https://www.saucedemo.com/v1/index.html");
		//maximize the window
		driver.manage().window().maximize();
		//Implementing Sikuli
		Screen s=new Screen();
		//Fill username in the text
		s.type("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\username.png", "standard_user");
		Thread.sleep(4000);
		s.type("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\cavisson_sikuli_locators\\password.png", "secret_sauce");
		Thread.sleep(3000);
		//Click on Sign In
		s.click("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\click_signIn.png");
		//Close the Browser
		driver.close();
		
		
		
		
	}

}
