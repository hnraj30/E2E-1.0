package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {
	public static void main(String[]args) throws InterruptedException, IOException
	{
		//Read all required data
		//Read all data from Property file
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read data from Excel file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue();
		String INDUSTRYTYPE = wb.getSheet("Organization").getRow(4).getCell(3).getStringCellValue();

		//Launch browser
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println(BROWSER +" browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println(BROWSER +" browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println(BROWSER +" browser launched");
		}
		else 
		{
			System.out.println("Invalid browser value");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Launch
		driver.get(URL);
		
		//Login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).submit();
		
		//Navigate to organizations and create organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//selecting a value from dropdown
		WebElement industryDD = driver.findElement(By.name("industry"));
		Select s = new Select(industryDD);
		s.selectByValue(INDUSTRYTYPE);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Verify
		System.out.println("Organization name: "+ORGNAME);
		String orgHeader = driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println("Saved Organization name: "+orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization created successfully: "+orgHeader);
		}
		else
		{
			System.out.println("Organization creation failed");
		}
		//logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(adminIcon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		System.out.println("Sign out completed");
		
	}
	
	

}
