package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	
	private static final String HUB_URL = "http://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initializeLambdaTestSession(String browser, String testName) {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("browserName", browser);
	    capabilities.setCapability("browserVersion", "127");

	    Map<String, Object> ltOptions = new HashMap<>();
	    ltOptions.put("user", "iamgopikrishnannm");
	    ltOptions.put("accessKey", "LT_LVmRq3fpB5lyDH32xCFt57U5Z3lHDvT2GqPkVnMcveXmupt");
	    ltOptions.put("build", "Selenium 4");
	    ltOptions.put("name", testName);
	    ltOptions.put("platformName", "Windows 10");
	    ltOptions.put("selenium_version", "4.7.0");
	    ltOptions.put("w3c", true);

	    capabilities.setCapability("LT:Options", ltOptions);

	    WebDriver driver = null;
	    try {
	        driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }

	    driverLocal.set(driver);
	    return driverLocal.get();
	}
	
	
	public static void quitSession() {
		if(driverLocal.get() != null) {
			driverLocal.get().quit();
		}
	}

	

}
