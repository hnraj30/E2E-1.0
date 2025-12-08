package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectrepository.ContactInfoPageN;
import objectrepository.ContactsPageN;
import objectrepository.CreateNewContactPageN;
import objectrepository.HomePageN;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2)+jUtil.getRandomNumber();
		//Click on Contacts
		HomePageN hp = new HomePageN(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on Contacts link");
		
		//Click on create new  contact
		ContactsPageN cp = new ContactsPageN(driver);
		cp.clickonCreateContactLookUpImg();
		Reporter.log("Clicked on Create new Contacts lookup img");

		//Create new contact
		CreateNewContactPageN cncp = new CreateNewContactPageN(driver);
		cncp.createNewcontact(LASTNAME);
		Reporter.log("Contact created");

		
		//Validate contact
		ContactInfoPageN cip = new ContactInfoPageN(driver);
		String contactName = cip.getHeaderText();
		//Assert.fail();
		Reporter.log("Contact name validated");

		
		Assert.assertTrue(contactName.contains(LASTNAME));
		System.out.println(contactName+" contact created successfully");
		Thread.sleep(3000);
	}
	@Test()
	public void demo()
	{
		System.out.println(" From Demo test script");
		//Assert.fail();
		System.out.println("Hi....");
		System.out.println("Adding primt statements for testing Poll SCM again");
	}
	

}
