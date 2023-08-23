package mobile.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import mobile.framework.CommonMethodsAndAssertions;



public class StepInForumPage extends CommonMethodsAndAssertions {

	private By videosTab = By.xpath("//a[text()='Videos']");
	private By ElementToSelect = By.xpath("//h4[@class='compact-media-item-headline']//span[text()='Testimonials by Jury Members']");
	private By skipAdButton = By.className("ytp-ad-skip-button-container");
	private By settingsButton = By.xpath("(//div[@class='player-controls-top']/button)[2]");
	//private By QualityButton =  By.xpath("//div[@class='ytp-menuitem-label' and text()='Quality']");
	//private By QualityDropDownButton =By.xpath("//select[contains(@id,'player-quality-dropdown')]"); 
	private By okButton = By.xpath("//button/div[text()='OK']");
	//h3[@class='media-item-headline']/span
	
	public void verifyPageTitle(String title) {
		verifyPageTitleAssertion(title);
	}

	public void navigateToVideos() throws Exception {
		click(videosTab);
	}

	public void scrollToElement() throws Exception {
		scroll(ElementToSelect);
		
	}

	public void clickVideo() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		click(ElementToSelect);
	}
	public void SkipAdAndChangeQuality() throws Exception {
		// TODO Auto-generated method stub
		clickIfOnlyPresent(skipAdButton);
		ActionsClick(settingsButton);
		//click(QualityButton);
		choose360p();
	}

	private void choose360p() throws Exception {
		// TODO Auto-generated method stub
		WebElement webelement = driver.findElement(By.xpath("//select[contains(@id,'player-quality-dropdown')]"));
		Select select = new Select(webelement);
		select.selectByValue("medium");
		click(okButton);

	}

	public void GetUpNextVideosAndWriteToJSON() {

		JSONObject jsonObject = new JSONObject();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("team", "siemens");
	      jsonObject.put("video", "stepin video");
	      
	      JSONArray upnextvideos = new JSONArray();
	      
	      List<WebElement> elements = driver.findElements(By.xpath("//h3[@class='media-item-headline']/span"));
	      for (int i=0; i<elements.size();i++){
	          String a = elements.get(i).getAttribute("innerHTML");
	          System.out.println(a);
	          upnextvideos.add(a); 
	        }

//	        listOfStates.add("Madhya Pradesh");  
//	        listOfStates.add("Maharastra");  
//	        listOfStates.add("Rajasthan");  

	        jsonObject.put("upcoming-videos", upnextvideos);
	      
	      try {
	          FileWriter file = new FileWriter(System.getProperty("user.dir")+"//OutputJSON");
	          file.write(jsonObject.toJSONString());
	          file.close();
	       } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	       }
	}
		
	
	
}
