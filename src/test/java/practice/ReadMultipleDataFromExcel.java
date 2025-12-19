package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadMultipleDataFromExcel {
	@Test(dataProvider="getData")
	public void createdMultipleOrganizations(String orgName, String indType)
	{
		System.out.println("OrgName:"+orgName+"		IndType:"+indType);
	}
	
	@DataProvider()
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MultipleOrganizations");
		
		int lastRowNum = sh.getLastRowNum();
		int lastCellNum = sh.getRow(0).getLastCellNum();
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);

		
		Object [][]data = new Object [lastRowNum][lastCellNum]; 
		 for(int i=0;i<lastRowNum;i++)
		 {
			 for(int j=0;j<lastCellNum;j++)
			 {
				 data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		 return data;
	}
	
	
	

}
