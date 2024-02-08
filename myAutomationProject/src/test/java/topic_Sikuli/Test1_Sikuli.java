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

public class Test1_Sikuli {
	
	public static void main(String[] args) throws FindFailed, InterruptedException {
		//Launch the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Go to Test Url
		driver.get("https://smallpdf.com/word-to-pdf");
		//maximize the window
		driver.manage().window().maximize();
		//Implementing Sikuli
		Screen s=new Screen();
		//TC: choose file button
		s.click("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\click_Choosefilebutton.png");
		Thread.sleep(5000);
		//TC: memory image
		Pattern fileInput=new Pattern("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\type_PathOfFile.png");
		Thread.sleep(4000);
		//send the path of the file into the textbox
		s.type(fileInput, "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\Test.docx");
		Thread.sleep(4000);
		//TC: click to open button
		s.click("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\click_open.png");
		Thread.sleep(4000);
		//TC: Webdriver wait to complete file conversion
		WebElement clickdownload=new WebDriverWait(driver, Duration.ofSeconds(30))
				                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Download']")));
		//TC:click on Download
		s.click("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\click_Download.png");
		Thread.sleep(4000);
		//Close the Browser
		driver.close();
		
		
		
		
	}

}
