package topic_AdvAnnotations;

import org.testng.annotations.Test;

public class TestSecurity {
  @Test(groups="security")
  public void openFileDialog() {
	  System.out.println("openFileDialog");
  }
  
  @Test(groups="security")
  public void openConfirmationDialog() {
	  System.out.println("openConfirmationDialog");
  }
  
  @Test(groups="security")
  public void closeFileDialog() {
	  System.out.println("closeFileDialog");
  }
}
