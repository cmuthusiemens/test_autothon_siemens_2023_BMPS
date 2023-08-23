package web.framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends PageFactory {

	WebDriver driver = null;

	
	  @BeforeTest(alwaysRun = true)
	  public void LaunchApp() { 
		  initialize(); 
		  }
	 

	void initialize() {
		driver = Driver.getInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}


//
//		@AfterTest(alwaysRun = true)
//		    public void CloseApp() {
//		       driver.quit();
//		    }

}
