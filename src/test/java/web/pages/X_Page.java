package web.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import web.framework.CommonMethodsAndAssertions;
import web.framework.Logger;
import web.utils.ConfigFileReader;



public class X_Page extends CommonMethodsAndAssertions {

	private By postButton = By.xpath("//span[text()='Post']");
	//*[@data-testid="tweetTextarea_0RichTextInputContainer"]
	//private By postTextArea = By.xpath ("(//div[@class='DraftEditor-editorContainer'])[2]");
	private By postTextArea = By.cssSelector("div.public-DraftStyleDefault-block.public-DraftStyleDefault-ltr");
	private By Post1=By.xpath("//span[contains(text(),'Super happy ')]");
	
	public void clickPost() throws Exception {
		click(postTextArea);
		//Thread.sleep(5000);
	}
	
	public void enterText1() throws Exception {
		
		type(ConfigFileReader.getPost1(), postTextArea);
	
	}
	public void postIt() throws Exception {
		click(postButton);
		//Thread.sleep(5000);
	}
	
	public void scrollToElement() throws Exception {
		scroll();
		
	}
	public void post1() throws Exception {
		click(Post1);
		//Thread.sleep(5000);
	}
	
	
/*
	
	public void OpenVideo() throws Exception {
		// TODO Auto-generated method stub
		ActionsClick(ElementToSelect);
	}

	public void SkipAdAndChangeQuality() throws Exception {
		// TODO Auto-generated method stub
		clickIfOnlyPresent(skipAdButton);
		click(settingsButton);
		click(QualityButton);
		choose360p();
	}

	private void choose360p() {
		// TODO Auto-generated method stub
		Actions key = new Actions(driver);
		key.keyDown(Keys.ARROW_UP)
		.keyDown(Keys.ARROW_UP)
		.keyDown(Keys.ARROW_UP)
		.keyDown(Keys.ENTER).perform();
		
	}

	public void GetUpNextVideosAndWriteToJSON() {
		// TODO Auto-generated method stub
		
		JSONObject jsonObject = new JSONObject();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("team", "siemens");
	      jsonObject.put("video", "stepin video");
	      
	      JSONArray upnextvideos = new JSONArray();
	      
	      List<WebElement> elements = driver.findElements(By.xpath("//div[@id='secondary-inner']//div[@id='items']//ytd-compact-video-renderer//span[@id='video-title']"));
	      for (int i=0; i<elements.size();i++){
	          String a = elements.get(i).getAttribute("title");
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
	}*/
	
}
