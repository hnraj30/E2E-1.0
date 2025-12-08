package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[]args) throws IOException
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println(LASTNAME);
		
		
		JavaUtility jUtil = new JavaUtility();
		int r = jUtil.getRandomNumber();
		System.out.println("Random Number: "+r);
		
		String date = jUtil.getSystemDate();
		System.out.println("Date: "+date);
		
		
		
		
	}

}
