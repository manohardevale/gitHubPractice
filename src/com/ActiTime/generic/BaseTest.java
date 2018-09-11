package com.ActiTime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ActiTime.pomclasses.LoginPage;

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
		
		LoginPage lp= new LoginPage(driver);
		String un=Utility.getPropertyValue("username");
		String pwd=Utility.getPropertyValue("password");
		lp.setUserName(un);
		lp.setPwd(pwd);		
		
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.close();
	}
}
