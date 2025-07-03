package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	protected static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching browser  "+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")){
			driver.set(new EdgeDriver());
		}
		else {
			logger.error("Please select chrome / edge browser to continue");
			System.err.println("Please select chrome / edge browser to continue");
		}
	}
	
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser  "+browserName);
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName == Browser.EDGE){
			driver.set(new EdgeDriver());
		}
		else{
			driver.set(new FirefoxDriver());
		}
 
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser in headless mode "+browserName);
		if(browserName == Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
			
		}
		else if(browserName == Browser.EDGE){
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		else{
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			}
			else {
				driver.set(new FirefoxDriver());
			}
		}
 
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	



	public void goToWebsite(String url) {
		logger.info("visiting the website "+ url);
		driver.get().get(url);	
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding element  with the locator "+ locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Element found performing click");
		webElement.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element  with the locator "+ locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Element found and entering the text "+ textToEnter);
		webElement.sendKeys(textToEnter);
	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element  with the locator "+ locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Element found and entering the special key "+ keyToEnter);
		webElement.sendKeys(keyToEnter);
	}
	
	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element  with the locator "+ dropDownLocator);
		WebElement webElement = driver.get().findElement(dropDownLocator);
		Select select = new Select(webElement);
		logger.info("Selecting the option "+ optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}
	
	public void clearText(By textBoxLocator) {
		logger.info("Finding element  with the locator "+ textBoxLocator);
		WebElement webElement = driver.get().findElement(textBoxLocator);
		logger.info("Element found, now clearing the text box field");
		webElement.clear();
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding element  with the locator "+ locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Element found and returning the visible text "+ webElement.getText());
		return webElement.getText();
	}
	public String getVisibleText(WebElement webElement) {
		logger.info("Returning visible text of webelement, "+ webElement);
		return webElement.getText();
	}
	
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all elements  with the locator "+ locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<>();
		logger.info("Elements found and now printing the list of elements");
		for(WebElement element: elementList) {
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}
	

	
	public String takeScreenshot(String testName) {
		TakesScreenshot screenshot;
		File screenshotData;
		Date date;
		SimpleDateFormat format;
		String timeStamp;
		String path=null;
		File screeshotFile;
		try {
			screenshot = (TakesScreenshot) driver.get();
			screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
			date = new Date();
			format= new SimpleDateFormat("HH-mm-ss");
			timeStamp = format.format(date);
			//path = System.getProperty("user.dir")+"//screeshots//"+testName+" - "+timeStamp+"png";
			path = "./screenshots/"+testName+" - "+timeStamp+"png";
			screeshotFile = new File(path);
			FileUtils.copyFile(screenshotData, screeshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void quit() {
		driver.get().quit();
	}
	

}
