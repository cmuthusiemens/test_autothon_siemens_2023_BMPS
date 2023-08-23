package mobile.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mobile.framework.BaseTest;
@Listeners (mobile.framework.TestStatusListener.class)
public class TC_009_SkipAdAndChangeQuality extends BaseTest {

	@Test
	public void SkipAdAndChangeQuality() throws Exception {
//		HomePage.Launch();
//		HomePage.verifyPageTitle("Home - YouTube");
//		HomePage.searchFor("step-inforum");
//		HomePage.OpenChannel();
//		StepInForumPage.navigateToVideos();
//		StepInForumPage.scrollToElement();
//		StepInForumPage.clickVideo();
		StepInForumPage.SkipAdAndChangeQuality();
	}

}
