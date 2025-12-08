package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.ContactInfoPageN;
import objectrepository.ContactsPageN;
import objectrepository.CreateNewContactPageN;
import objectrepository.CreateNewOrganizationPageN;
import objectrepository.HomePageN;
import objectrepository.LoginPageN;
import objectrepository.OrganizationInfoPageN;
import objectrepository.OrganizationsPageN;

public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups="RegressionSuite")
	public void createContactWithOrgTest() throws IOException, InterruptedException
	{
				
				
				//Read the required data
				String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber()+jUtil.getRandomNumber();
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2)+jUtil.getRandomNumber()+jUtil.getRandomNumber();
				
				
				//Click on Organization
				HomePageN hp = new HomePageN(driver);
				hp.clickOnOrgLink();
				
				//Click on create new org
				OrganizationsPageN op = new OrganizationsPageN(driver);
				op.clickonCreateOrgLookUpImg();
				
				//Create org
				CreateNewOrganizationPageN cnop = new CreateNewOrganizationPageN(driver);
				cnop.createNewOrganization(ORGNAME);
				
				//Validate org name
				OrganizationInfoPageN oip = new OrganizationInfoPageN(driver);
				String orgHeader = oip.getHeaderText();
				
				Assert.assertTrue(orgHeader.contains(ORGNAME));
						
				hp.clickOnContactsLink();
				
				ContactsPageN cp = new ContactsPageN(driver);
				cp.clickonCreateContactLookUpImg();
		
				//Create New contact with org
				CreateNewContactPageN cncp = new CreateNewContactPageN(driver);
				cncp.createNewcontact(driver, LASTNAME, ORGNAME);
				
				ContactInfoPageN cip = new ContactInfoPageN(driver);
				String contactHeader = cip.getHeaderText();
				
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				
				Thread.sleep(3000);
					
	}
	

}
