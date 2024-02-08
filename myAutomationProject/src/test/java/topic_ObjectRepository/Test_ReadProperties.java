package topic_ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Test_ReadProperties {
	WebDriver driver;
  @Test
  public void sdLogin() throws IOException, InterruptedException {
	  Properties prop=new Properties();
	  FileInputStream ip=new FileInputStream("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\java\\topic_ObjectRepository\\config.properties");
	  prop.load(ip);
	  //Name
	  String Name=prop.getProperty("name");
	  System.out.println(Name);
	  //Age
	  String Age=prop.getProperty("age");
	  System.out.println(Age);
	  //URL
	  String URL=prop.getProperty("url");
	  System.out.println(URL);
	  //Browser
	  String browser=prop.getProperty("browser");
	  System.out.println(browser);
	  
	  if(browser.equals("chrome")) {
		  driver=new ChromeDriver();
	  }else if(browser.equals("Firefox")) {
		  driver=new FirefoxDriver();
	  }else if(browser.equals("Edge")) {
		  driver=new EdgeDriver();
	  }
	  //Goto Test Url
	  driver.get(URL);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //Maximazie the browser
	  driver.manage().window().maximize();
	  
	  //Fill Username with input
	  driver.findElement(By.xpath(prop.getProperty("UsernameFilled"))).sendKeys("username");
	  Thread.sleep(3000);
	  //Fill password with input
	  driver.findElement(By.xpath(prop.getProperty("PasswordField"))).sendKeys("password");
	  Thread.sleep(3000);
	  //Click on Login
	  driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
}
