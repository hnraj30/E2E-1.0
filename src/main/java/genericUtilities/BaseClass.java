package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.LoginPageN;
import objectrepository.HomePageN;

public class BaseClass {
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
	//for listeners
	public static WebDriver sdriver;
	
	//We should keep annotations used in BaseClass running always
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("-----------------DB Connection successfull-----------------");
	}

	//@Parameters("browser")
	//@BeforeTest()
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
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
		//Load appln
		driver.get(URL);
		//Implicit wait
		wUtil.waitForPageLoad(driver);	
		
		sdriver = driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		//Login to the application
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPageN lp = new LoginPageN(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	//-----------Test script execution---------------
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws IOException, InterruptedException
	{
		HomePageN hp = new HomePageN(driver);
		hp.logoutOfApp(driver);
		Thread.sleep(2000);
	}
	//@AfterTest()
	@AfterClass(alwaysRun=true)
	public void acConfig() 
	{
		driver.close();
		System.out.println("Browser closed successfully");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("-----------------DB disconnected successfully-----------------");
	}
}
