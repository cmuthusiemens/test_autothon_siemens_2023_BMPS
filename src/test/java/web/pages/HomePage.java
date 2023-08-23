package web.pages;

import org.openqa.selenium.By;

import web.framework.CommonMethodsAndAssertions;
import web.utils.ConfigFileReader;


public class HomePage extends CommonMethodsAndAssertions {

	private By userName = By.xpath("//input[@autocomplete='username']");
	private By nextButton = By.xpath("//div[@role='button']//span[text()='Next']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//div[@role='button']//span[text()='Log in']");

	public void Launch() throws Exception {
		String url = ConfigFileReader.getApplicationUrl(); 
		open(url);
		//takeScreenshot();
	//	enterUsername();
		//enterPassWord();
		//clickSubmitbutton();
		System.out.println("Logging in...");

	}
	

	public void verifyPageTitle(String title) {
		verifyPageTitleAssertion(title);
	}


/*	private void clickSubmitbutton() throws Exception {
		// takeScreenshot();
		click(submitButton);
	}*/

	public void enterUsername() throws Exception {
		type(ConfigFileReader.getUserName(), userName);
	}
	
	public void clickNext() throws Exception {
		click(nextButton);
	}

	public void enterPassWord() throws Exception {
		type(ConfigFileReader.getPassWord(), password);
	}
	
	public void clickLogin() throws Exception {
		click(loginButton);
	}
	
	/*public void searchFor(String searchText) throws Exception {
		type(searchText, searchBox);	
		clickSearchbutton();
	}

	private void clickSearchbutton() throws Exception {
		click(searchButton);
	}

	public void OpenChannel() throws Exception {
		//Thread.sleep(5000);
		click(OpenChannelButton);
	}
*/
	

}
