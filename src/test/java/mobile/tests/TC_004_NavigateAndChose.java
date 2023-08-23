package mobile.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mobile.framework.BaseTest;
@Listeners (mobile.framework.TestStatusListener.class)
public class TC_004_NavigateAndChose extends BaseTest {

	@Test
	public void TC_004NavigateAndChose() throws Exception {
//		HomePage.Launch();
//		HomePage.verifyPageTitle("Home - YouTube");
//		HomePage.searchFor("step-inforum");
//		HomePage.OpenChannel();
		StepInForumPage.navigateToVideos();
	}

}
