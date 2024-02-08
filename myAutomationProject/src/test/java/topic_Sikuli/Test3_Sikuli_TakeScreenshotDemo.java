package topic_Sikuli;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Test3_Sikuli_TakeScreenshotDemo {

	public static void main(String[] args) throws InterruptedException, FindFailed, IOException {
		// Launch the Browser
		WebDriver driver=new ChromeDriver();
		//Goto Test URL
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//implementing Sikuli
		Screen s=new Screen();
		s.type("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\username.png", "standard_user");
		s.type("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\password.png", "secret_sauce");
	//TC: Take Screenshot using Sikuli
		//Capture Entire screen
		ScreenImage si=s.capture();
		//Stored into Buffer
		BufferedImage bi=si.getImage();
		//Stored the screenshot in specified location and give meaningful name
		File f=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\Test3_Sikuli_Screenshot\\Login_snaps.png");
		//Now Save it
		ImageIO.write(bi, "PNG", f);
		Thread.sleep(3000);
		
		s.click("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\sikuli_locators\\cavisson_sikuli_locators\\click_signIn.png");
		Thread.sleep(3000);
       //close the Browser
		driver.close();
	}

}
