package com.ActiTime.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility implements IAutoConst {

	public static String getPropertyValue(String PropertyName)
	{
		String PropertyValue ="";
		Properties prop = new Properties();
		
		try {
		
			prop.load(new FileInputStream(CONFIG_PATH));
		PropertyValue = prop.getProperty(PropertyName);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return PropertyValue;
		
	}
	
	
}
