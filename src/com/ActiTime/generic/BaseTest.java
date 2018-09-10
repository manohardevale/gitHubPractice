package com.ActiTime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{

	public WebDriver driver;
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(GECKO_KEY, GECKO_PATH);
	}
	
	@BeforeMethod
	public void openApp()
	{
		driver = new FirefoxDriver();
		String url = Utility.getPropertyValue("URL");
		driver.get(url);
		String ITO = Utility.getPropertyValue("ITO");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ITO), TimeUnit.SECONDS);		
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.close();
	}
}
