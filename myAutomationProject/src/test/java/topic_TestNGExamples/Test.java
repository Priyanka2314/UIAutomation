package topic_TestNGExamples;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Goto Test url
		driver.get("https://www.selenium.dev/");
		Thread.sleep(5000);
		//Close the active Browser
		driver.close();
		
		

	}

}
