package web.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import web.framework.BaseTest;
import web.pages.X_Page;
@Listeners (web.framework.TestStatusListener.class)
public class TC_004_clickPost extends BaseTest {
	 public static Logger log= LogManager.getLogger(TC_004_clickPost.class.getName());

	@Test
	public void clickPost() throws Exception {
		X_Page.post1();
	}

}
