package topic_AdvAnnotations;

import org.testng.annotations.Test;

public class TestUI2 {
	@Test(groups="ui")
	  public void accessHomePage2() {
		  System.out.println("accessHomePage2");
	  }
	  
	  @Test(groups="ui")
	  public void contactUsPage2() {
		  System.out.println("contactUsPage2");
	  }
	  
	  @Test(groups="ui")
	  public void accessCompaignPage2() {
		  System.out.println("accessCompaignPage2");
	  }

}
