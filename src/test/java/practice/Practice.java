package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice {
	int count=0;
	@Test(dataProvider="getData")
	public  void excelAndDataProvider(String brand, String model, long price,int quantity) throws IOException
	{
		//Data provider
		System.out.println("Brand:"+brand+"		Model:"+model+"	Price:"+price+"	Quantity:"+quantity);
		
		//Write data to Excel file
		FileInputStream fise = new FileInputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		Workbook wb2 = WorkbookFactory.create(fise);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");

		wb2.getSheet("DataProvider").createRow(0+count).createCell(0).setCellValue(brand);
		
		wb2.write(fos);
		count++;
		
		
		/*
		//Read data from property file
		Properties pUtil = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
		pUtil.load(fis);
		String BROWSER = pUtil.getProperty("browser");
		System.out.println(BROWSER);
		
		//Read data from Excel file
		FileInputStream fise = new FileInputStream("D:\\Maven_Projects\\E2E-1.0\\src\\test\\resources\\TestData.xlsx");
		//Workbook wb = WorkbookFactory.create(fise);
		//String name = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		//System.out.println(name);
		
		
		
		Workbook wb2 = WorkbookFactory.create(fise);
		wb2.getSheet("Contacts").createRow(20).createCell(3).setCellValue("Test data from java");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		wb2.write(fos);
		
		*/
		
	
	
	}
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object [3][4];
		data[0][0] = "Samsung";
		data[0][1] = "S25+";
		data[0][2] = 100000;
		data[0][3] = 5;
		data[1][0] = "Moto";
		data[1][1] = "Edge 50";
		data[1][2] = 30000;
		data[1][3] = 10;
		data[2][0] = "Nothing";
		data[2][1] = "3a Pro";
		data[2][2] = 32000;
		data[2][3] = 10;
		return data;
		
	}
	

}
