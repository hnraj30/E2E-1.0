package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {
	public static void main(String[]args) throws IOException, InterruptedException
	{
		//Create all the required objects
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver=null;
		
		//Read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2)+jUtil.getRandomNumber();

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" browser launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		//Maximize window
		wUtil.maximizeWindow(driver);
		
		//load appln
		driver.get(URL);
		
		//Implicit wait
		wUtil.waitForPageLoad(driver);
		
		//Login to appln
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		
		//Validate organization
		String orgHeaderText = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(orgHeaderText.contains(ORGNAME))
		{
			System.out.println("Organization: "+orgHeaderText+" created successfully");
		}
		else
		{
			System.out.println("Organization creation failed");

		}
		
		//Create contact using organization name
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Switch control to child window
		wUtil.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		
		wUtil.switchToWindow(driver, "Contacts");
				
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		
		//Validate organization
		String contactHeaderText = driver.findElement(By.id("dtlview_Last Name")).getText();
				
		if(contactHeaderText.contains(LASTNAME))
		{
			System.out.println("Contact: "+contactHeaderText+", with Organization: "+ORGNAME+", created successfully");
		}
		else
		{
			System.out.println("Contact with Organization creation failed");

		}		
	
		
		//Logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, adminIcon);
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		driver.close();
		

}
}
