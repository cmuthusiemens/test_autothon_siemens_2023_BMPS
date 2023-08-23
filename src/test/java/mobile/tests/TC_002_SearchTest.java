package mobile.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mobile.framework.BaseTest;
@Listeners (mobile.framework.TestStatusListener.class)
public class TC_002_SearchTest extends BaseTest {

	@Test
	public void test() throws Exception {
//		HomePage.Launch();
//		HomePage.verifyPageTitle("Home - YouTube");
		HomePage.searchFor("step-inforum");
	
	}

}
