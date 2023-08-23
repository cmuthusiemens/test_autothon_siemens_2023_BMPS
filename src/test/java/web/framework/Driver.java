package web.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import web.utils.ConfigFileReader;

public class Driver {
	protected static WebDriver driver;

    public  static  WebDriver getInstance() 
    
    {
    	String browser = ConfigFileReader.getDriver();
    	
    	if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"//chromedriver.exe");
			driver = new ChromeDriver();
		}
    	
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//msedgedriver.exe");
			driver = new EdgeDriver();
		}
        return driver;
    }
}
