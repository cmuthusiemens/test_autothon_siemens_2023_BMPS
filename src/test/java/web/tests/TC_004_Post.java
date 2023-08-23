package web.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import web.framework.BaseTest;
import web.pages.X_Page;
@Listeners (web.framework.TestStatusListener.class)
public class TC_004_Post extends BaseTest {
	 public static Logger log= LogManager.getLogger(TC_004_Post.class.getName());

	@Test
	public void clickPost() throws Exception {
		X_Page.clickPost();
		Thread.sleep(6000);
		//log.info("Clicked Post");
		System.out.print("Clicked");
		X_Page.enterText1();
		X_Page.postIt();
	}

}
