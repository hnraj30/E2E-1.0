package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Launch
		driver.get("http://localhost:8888/");
		
		//Login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		//Navigate to contacts and create contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		String lastName = "Harikant105";
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//selecting a org from org lookup
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Set<String> child = driver.getWindowHandles();
		for(String c:child)
		{
			driver.switchTo().window(c);
		}
		String orgName = "Qspiders2136";
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		driver.switchTo().window(parent);		
		Thread.sleep(3000);
		
		//Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Verify contact name
		System.out.println("Last name: "+lastName);
		String contactHeader = driver.findElement(By.id("dtlview_Last Name")).getText();
		System.out.println("Saved Last name: "+contactHeader);
		if(contactHeader.contains(lastName))
		{
			System.out.println("contact created successfully: "+contactHeader);
		}
		else
		{
			System.out.println("Contact creation failed"+contactHeader);
		}
	
		
		//logout
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(adminIcon).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		
		
	}
		
		
	
	
	

}
