package topic_AdvAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestUI {
  
//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("@BeforeTest-----UI Login");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("@AfterTest-----UI Logout");
//  }
  
  @Test(groups="ui")
  public void accessHomePage() {
	  System.out.println("accessHomePage");
  }
  
  @Test(groups="ui")
  public void contactUsPage() {
	  System.out.println("contactUsPage");
  }
  
  @Test(groups="ui")
  public void accessCompaignPage() {
	  System.out.println("accessCompaignPage");
  }

}
