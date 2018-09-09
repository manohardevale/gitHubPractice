package com.ActiTime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver = new ChromeDriver();
		String url = Utility.getPropertyValue("URL");
		driver.get(url);
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.close();
	}
}
