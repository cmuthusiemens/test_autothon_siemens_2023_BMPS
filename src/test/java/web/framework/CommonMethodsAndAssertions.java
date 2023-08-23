package web.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethodsAndAssertions extends Driver {

	protected void open(String url) throws Exception {
		try {
			driver.get(url);

		} catch (Exception e) {
			Logger.error("Exception in open()");
			Logger.error(e.toString());
			throw new Exception(e);
		}
	}
	
	
	protected void type(String testdata, By by) throws Exception {
		try {

			//driver.findElement(by).clear();
			driver.findElement(by).sendKeys(testdata);
		} catch (Exception e) {
			Logger.error("Exception in type()");
			Logger.error(e.toString());
			throw new Exception(e);

		}

	}
	


	protected void click(By by) throws Exception {
		try {
			// takeScreenshot();
			driver.findElement(by).click();
		} catch (Exception e) {
			Logger.error("Exception in click()");
			Logger.error(e.toString());
			throw new Exception(e);

		}

	}
	
	protected void ActionsClick(By by) throws Exception {
		try {
			// takeScreenshot();
			Thread.sleep(5000);
			driver.findElement(by).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(by));
			
		}
	}
	
	protected void clickIfOnlyPresent(By by) throws Exception {
		try {
			List<WebElement> x = driver.findElements(by);
			if (x.size() > 0) {
			x.get(0).click();
			}
		} catch (Exception e) {
			Logger.error("Exception in click()");
			Logger.error(e.toString());
			//throw new Exception(e);

		}

	}
	
	protected String takeScreenshot(String string) throws IOException, InterruptedException {
		Thread.sleep(500);
		String directoryName = System.getProperty("user.dir") + "//Screenshots"+"_"+string+"//";
		File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	    }
	    
	   	    
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "//Screenshots"+"_"+string+"//"+ GetTimeStampValue()+ ".png");
		String dest = System.getProperty("user.dir") + "//Screenshots"+"_"+string+"//"+ GetTimeStampValue()+ ".png";
		FileHandler.copy(srcFile, destFile);
		return dest;

	}
	
	
	

	public String GetTimeStampValue() throws IOException {
		Date d = new Date();
		String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
		return TimeStamp;
	}

	protected void scroll() throws Exception {
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
/*	try {
		
		//System.out.println(element);
////			JavascriptExecutor js = (JavascriptExecutor) driver;
////			js.executeScript("arguments[0].scrollIntoView(true);", element);
////			element.click();
//			//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
//			Actions action = new Actions(driver);
//			action.moveToElement(element);
//			try {
			    	//long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollHeight");
			    	//System.out.println(lastHeight);
			    	int i =400;
			    	int newHeight;
			 
			    	do {
			    		   try {	
			        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+i+")");
			       // Thread.sleep(1000);
			        newHeight =175; 
			       // long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollHeight");
			        //System.out.println(newHeight);
			       // WebElement element = driver.findElement(By.xpath("(//a[@id='video-title-link'])[90]"));
			       //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			        i = newHeight+i;
			        WebElement elementToSelect = driver.findElement(element);
			       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToSelect);
			       boolean flag = elementToSelect.isDisplayed();
			       
			       if (flag) {
			        System.out.println(flag); 
			        i=i+50;
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"+"window.scrollBy(0,-250);", elementToSelect);
			        
			        break;
			       }
//			        if (flag) {
//			        	continue;
//			        }
			     
			       
			    }
			    
			    	catch (Exception e) {
			    		continue;
			    	}
			    }while (true);
			
//		} catch (Exception e) {
//			Logger.error("Exception in type()");
//			Logger.error(e.toString());
//			//throw new Exception(e);
//
//		}*/

	}
	
	/************************* Assertions ************************************/

	protected void verifyPageTitleAssertion(String title) {
		Assert.assertEquals(driver.getTitle(), title, "Title is not matching");
	}
}
