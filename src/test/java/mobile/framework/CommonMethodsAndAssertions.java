package mobile.framework;

import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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

import web.framework.Logger;

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

			driver.findElement(by).clear();
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
	protected void ActionsClick(By by) throws Exception {
		try {
			// takeScreenshot();
			Thread.sleep(1000);
			driver.findElement(by).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(by));
			
		}
	}
	
	protected String takeScreenshot(String string) throws IOException, InterruptedException {
		String directoryName = System.getProperty("user.dir") + "//Screenshots"+"_"+string+"//";
		File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	    }
	    
	   	Thread.sleep(1000);
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

	protected void scroll(By element) throws Exception {
		int i =400;
    	int newHeight;
 
    	do {
    		   try {	
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+i+")");
        newHeight =400; 
        i = newHeight+i;
        WebElement elementToSelect = driver.findElement(element);
        boolean flag = elementToSelect.isDisplayed();
        if (flag) {
	        System.out.println(flag); 
	        i=i+50;
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToSelect);
	        
	        break;
	       }
    		   }
			    
		    	catch (Exception e) {
		    		continue;
		    	}
		    }while (true);
	}

	/************************* Assertions ************************************/

	protected void verifyPageTitleAssertion(String title) {
		Assert.assertEquals(driver.getTitle(), title, "Title is not matching");
	}
}
