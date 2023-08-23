package web.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import web.framework.BaseTest;
@Listeners (web.framework.TestStatusListener.class)
public class TC_002_Login extends BaseTest {

	@Test
	public void Login() throws Exception {
		//HomePage.Launch();
		//HomePage.verifyPageTitle("YouTube");
		HomePage.enterUsername();
		HomePage.clickNext();
		HomePage.enterPassWord();
		HomePage.clickLogin();
	
	}

}
