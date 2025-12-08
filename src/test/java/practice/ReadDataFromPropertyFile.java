package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[]args) throws IOException
	{
		//Open the doc in Java readable format
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Create object of Properties
		Properties p = new Properties(); 
		
		//Load the file input stream into properties
		p.load(fis);
		
		//Provide the key and read the value
		String browser = p.getProperty("browser");
		System.out.println(browser);
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

		
		
	}
	

}
