package mobile.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import mobile.utils.ConfigFileReader;

public class Driver {
	protected static WebDriver driver;

    public  static  WebDriver getInstance() 
//    	String exePath = ConfigFileReader.getDriverPath();
//		System.setProperty("webdriver.chrome.driver", exePath);
//		/*Mobile Emulation */
//		Map<String, String> mobileEmulation = new HashMap<>();
//		mobileEmulation.put("deviceName", "Nexus 5");
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//		driver = new ChromeDriver(chromeOptions);
//   
//		//driver = new ChromeDriver();
//        return driver;
//
//    }
    {
    	String browser = ConfigFileReader.getDriver();
    	
    	if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"//chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Pixel 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			
			//iPhone 12 Pro
			//Pixel 5
			//Nexus 5
			//JioPhone 2
//			mobileEmulation.put("width", "390");
//			mobileEmulation.put("height", "844");
//			mobileEmulation.put("pixelRatio", "100");
//			mobileEmulation.put("mobile", "true");
//			ChromeDriver driver = new ChromeDriver();
//			DevTools devTools = driver.getDevTools();
//			devTools.createSession();
//			// iPhone 11 Pro dimensions
//			devTools.send(Emulation.setDeviceMetricsOverride(375,
//			                                                 812,
//			                                                 50,
//			                                                 true,
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty(),
//			                                                 Optional.empty()));
				driver = new ChromeDriver(chromeOptions);
	   
			//driver = new ChromeDriver();
		}
    	
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//msedgedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new EdgeDriver(edgeOptions);
	   
			//driver = new EdgeDriver();
		}
        return driver;
    }
}
