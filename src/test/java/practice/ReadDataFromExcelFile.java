package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		//Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Navigate to required row
		Row rw = sh.getRow(1);
		
		//Navigate to required cell
		Cell cl = rw.getCell(2);
		
		//Capture the value and print
		String value = cl.getStringCellValue();
		System.out.println(value);
		
		System.out.println(wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue());
		
		
		
		//Write Data into Excel file
		FileInputStream fis2 = new FileInputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		Workbook wb2 = WorkbookFactory.create(fis2);
		wb2.getSheet("Contacts").createRow(13).createCell(0).setCellValue("Test Data");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\hnraj\\Desktop\\TestData.xlsx");
		wb2.write(fos);
		
		
	}

}
