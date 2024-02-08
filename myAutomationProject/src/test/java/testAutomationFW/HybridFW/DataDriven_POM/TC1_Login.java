package testAutomationFW.HybridFW.DataDriven_POM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC1_Login {
	static Page_Login login;
	static WebDriver driver;
	@Test(dataProvider="sd_testdata")
  public void verifySDLogin(String uname,String pwd) throws InterruptedException {
	//TC 1: Launch Chrom Browser
		 driver = new ChromeDriver();
	 // TC 2: Go to Test Url
		    driver.get("https://www.saucedemo.com/v1/");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 // TC 3: manage the browser window to maximize -  Maximize Browser Window
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    
		    login=new Page_Login(driver);
		  //Fill Username Textbox with input
		    login.type_Username(uname);
		  // Fill password Textbox with input
		    login.type_UPassword(pwd);
		  // Click on Login Button
		    login.click_Login();
		  //TC 7: Verify Login 
		     String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
		     String actualUrl = driver.getCurrentUrl();
		    Assert.assertEquals(actualUrl, expectedUrl);
  }
  
  @AfterMethod
//TC 8: Close the Browser 
  public void getResult(ITestResult testResult) {
	  System.out.println("TestCase Name:"+testResult.getName());
	  System.out.println("TestCase Result:"+testResult.getStatus()); //if result is 1 -> pass or if it's 2 -> fail
	  int status=testResult.getStatus();
	  if(status==1) {
		  driver.close();
	  }else {
		  //Take Screenshot
		  File screenshotsrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			  String fn=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
			  File targetFile=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\TC2Snaps_HybridFW\\"
			                   +testResult.getParameters()[0]+"_"+fn+".png");
			FileUtils.copyFile(screenshotsrcFile,targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.close();
	  }
	  
	  
  }
  
  @DataProvider(name="sd_testdata")
  public Object[][] readExcel() throws BiffException, IOException{
	  //open File to read and write, which is available in the same package
	  File f=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\allResouceFiles\\TestData_SwagDemo.xls");
	  Workbook w=Workbook.getWorkbook(f);
	  Sheet s=w.getSheet(0);
	  
	  int noOfRows=s.getRows();
	  int noOfColumns=s.getColumns();
	  
	  //Creating an array to store the data of an Excel sheet
	  String inputData[][]=new String[noOfRows-1][noOfColumns];
	  int count=0;
	  for(int i=1;i<noOfRows;i++) {
		  for(int j=0;j<noOfColumns;j++) {
			  Cell c=s.getCell(j, i);
			  inputData[count][j]=c.getContents();
		  }
		  count++;
	  }
	return inputData;
	  
  }
}
