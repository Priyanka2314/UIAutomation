package topic_ITest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testrescontext2forControlParameter2ndWay {
	WebDriver driver;
	@Parameters(("browser"))
  @BeforeMethod
  public void setup(String Browser) {
	  System.out.println("Setup method");
//	  String Browser=testcontext.getCurrentXmlTest().getParameter("browser");
	  if(Browser.equals("chrome")) {
		  driver=new ChromeDriver();
	  }else if(Browser.equals("firefox")) {
		  driver=new FirefoxDriver();
	  }else if(Browser.equals("edge")) {
		  driver = new EdgeDriver();
	  }
	  
  }
  
  @AfterMethod
  public void teardown(ITestResult result) {
	  System.out.println("TestCase Name:"+result.getName());
	  System.out.print("TestCase Result:"+result.getStatus());
	  File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 int status=result.getStatus();
	 if(status==1) {
		 driver.close();
	 }else if(status==2) {
	  try {
		  String fn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
		  File targetFile=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\TestrescontextSnaps\\"
	                      +"_"+result.getName()+fn+".png");
		FileUtils.copyFile(screenshotFile,targetFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  driver.close();
   }
  }
  @Parameters({"username","password"})
  @Test
  public void sdLogin(String uname,String pwd) throws InterruptedException {
	// TC 2: Go to Test Url
	    driver.get("https://www.saucedemo.com/v1/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
// TC 3: manage the browser window to maximize -  Maximize Browser Window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
// TC 4: Fill Username Textbox with input
	    driver.findElement(By.id("user-name")).sendKeys(uname);
	    Thread.sleep(3000);
// TC 5: Fill password Textbox with input
	    driver.findElement(By.id("password")).sendKeys(pwd);
	    Thread.sleep(3000);
// TC 6: Click on Login Button
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	    Thread.sleep(3000);
//TC 7: Verify Login 
	     String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
	     String actualUrl = driver.getCurrentUrl();
	     Assert.assertEquals(actualUrl, expectedUrl);
  }
}
