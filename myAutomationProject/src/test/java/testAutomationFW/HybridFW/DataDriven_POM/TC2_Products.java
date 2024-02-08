package testAutomationFW.HybridFW.DataDriven_POM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

public class TC2_Products {
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
		  //Verify Product text
		     String expectedtxt="Products";
		     String actualtxt = login.capture_Producttxt();
		    Assert.assertEquals(actualtxt, expectedtxt);
		  //Click on Add to Cart Button
		    login.click_AddtoCart();
		  //Click on shopping cart Button
		    login.click_shopping_cart();
		  //Verify Cart text
		    String expectedCartTxt="Your Cart";
		    String actualCartTxt=login.capture_text_Cart();
		    Assert.assertEquals(actualCartTxt, expectedCartTxt);
		    Thread.sleep(5000);
  }
  
  @AfterMethod
  public void teardown() {
	 driver.close();
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
