package web.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.framework.BaseTest;
@Listeners (web.framework.TestStatusListener.class)
public class TC_001_OpenWebsite extends BaseTest {
	
	 public static Logger log= LogManager.getLogger(TC_001_OpenWebsite.class.getName());

	@Test
	public void OpenWebsite() throws Exception {
		HomePage.Launch();
		log.info("Page launched");
		HomePage.verifyPageTitle("Log in to Twitter / X");
		log.info("Page Title Verified");

	}

}
