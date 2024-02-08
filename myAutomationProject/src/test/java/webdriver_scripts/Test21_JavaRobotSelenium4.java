// Test Scenario 
//  *************
//  TC1: Launch the Chrome Browser
//  TC2: Goto Test URL
//  TC3: Minimize Browser Window
//  TC4: Maximize Browser Window
//  TC5: Get the Title of the Page
//  TC6: Get the Current URL of the Page
//  TC7: Close the Browser

package webdriver_scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test21_JavaRobotSelenium4 {

	public static void main(String[] args) throws InterruptedException, AWTException {
//  TC 1: Launch the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Personal_Workspace\\Oct14th_2023\\Automation\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//	TC 2: Goto Test URL
		driver.get("https://smallpdf.com/word-to-pdf");
		
		//Wait Time 5 sec 1sec=1000ms
		Thread.sleep(5000);
//	TC 3: manage the browser window to maximize -  Maximize Browser Window
		driver.manage().window().maximize();
		//Wait Time 3 sec 1sec=1000ms
		Thread.sleep(3000);
//  TC 4: Click on choose file Button
		driver.findElement(By.xpath("//span[text()='Choose Files']")).click();
		Thread.sleep(3000);
//	TC 5:
		//Path of File -> E:\ME\Priyanka_Singh.pdf
		//Load the Path of File into Clipboard.
		StringSelection s=new StringSelection("E:\\ME\\Priyanka_Singh.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		//Send the data from Clipboard to screen
		//Paste Operation(Ctrl+V)
		//Implement Java Robot to Handle Window Alert
		Robot r =new Robot();
		//Paste instructions (Ctrl+V)
		r.keyPress(KeyEvent.VK_CONTROL); //Press ctrl key
		r.keyPress(KeyEvent.VK_V);//Press V key
		Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_V); //Release V key
		r.keyRelease(KeyEvent.VK_CONTROL); //Release ctrl key
		Thread.sleep(3000);
		//code for Enter instruction after Paste
		r.keyPress(KeyEvent.VK_ENTER); //Press Enter
		r.keyRelease(KeyEvent.VK_ENTER); //Release Enter
//		Thread.sleep(15000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicit wait
		WebElement clickToDownload=new WebDriverWait(driver, Duration.ofSeconds(5)).
				        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Download']")));
//	TC 6: Click on Download button
//		driver.findElement(By.xpath("//span[text()='Download']")).click();
//		Thread.sleep(8000);
//	TC7: Close the Active Browser Window 
		driver.close();
	}

}
