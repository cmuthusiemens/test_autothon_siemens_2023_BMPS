package web.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private static Properties properties;
	private final String propertyFilePath= "config.properties";

	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			    reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public static String getDriver(){
		String browser = properties.getProperty("browser");
		//System.out.println("TTT"+driverPath);
		if(browser!= null) return browser;
		else throw new RuntimeException("browser driver not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public static String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getUserName() {
		String userName = properties.getProperty("Username");
		if(userName != null) return userName;
		else throw new RuntimeException("Username not specified in configuration.properties file.");
	}
	
	public static String getPassWord() {
		String passWord = properties.getProperty("Password");
		if(passWord != null) return passWord;
		else throw new RuntimeException("Password not specified in configuration.properties file.");
	}
	
	public static String getPost1() {
		String post1 = properties.getProperty("post1");
		if(post1 != null) return post1;
		else throw new RuntimeException("Post not specified in configuration.properties file.");
	}

}