package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read data from Excel file
 * @author hnraj
 *
 */
public class ExcelFileUtility {
	/**
	 * This method reads data from excel file and returns it to the caller
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return value;
	}
	
	//Read multiple data from Excel file
	/**
	 * This method reads multiple data from Excel file
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		Workbook wb2 = WorkbookFactory.create(fise);
		Sheet sh = wb2.getSheet(sheetName);
		
		int rowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rowNum][cellNum];
		
		for(int i=0;i<rowNum;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
	

}
