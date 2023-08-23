package mobile.pages;

import org.openqa.selenium.By;

import mobile.framework.CommonMethodsAndAssertions;
import mobile.utils.ConfigFileReader;


public class HomePage extends CommonMethodsAndAssertions {

	private By searchBox = By.name("search");
	private By searchButton = By.className("topbar-menu-button-avatar-button");
	private By FinalSearch = By.xpath("//div[@class='searchbox-input-wrapper']/button[@class='icon-button ']");
	private By OpenChannelButton = By.xpath("//a[@class='compact-media-item-image']");

	public void Launch() throws Exception {
		String url = ConfigFileReader.getApplicationUrl(); 
		open(url);
		//takeScreenshot();
		//enterUsername();
		//enterPassWord();
		//clickSubmitbutton();
		System.out.println("Logging in...");

	}
	/*
private void clickSubmitbutton() throws Exception {
		 takeScreenshot();
		click(submitButton);
	}
/*
	private void enterUsername() throws Exception {
		type(ConfigFileReader.getUserName(), userName);
	}

	private void enterPassWord() throws Exception {
		type(ConfigFileReader.getPassWord(), passWord);
	}
*/
	public void verifyPageTitle(String title) {
		verifyPageTitleAssertion(title);
	}

	public void searchFor(String searchText) throws Exception {
		clickSearchbutton();
		type(searchText, searchBox);
		clickFinalSearchbutton();
	}

	private void clickFinalSearchbutton() throws Exception {
		// TODO Auto-generated method stub
		click(FinalSearch);
	}

	private void clickSearchbutton() throws Exception {
		click(searchButton);
	}

	public void OpenChannel() throws Exception {
		click(OpenChannelButton);
	}

}
