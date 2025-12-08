package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectrepository.CreateNewOrganizationPageN;
import objectrepository.HomePageN;
import objectrepository.OrganizationInfoPageN;
import objectrepository.OrganizationsPageN;

public class CreateOrganizationTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createOrganizationTest() throws EncryptedDocumentException, IOException
	{
		//Read all required data
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		HomePageN hp = new HomePageN(driver);
		hp.clickOnOrgLink();
		
		OrganizationsPageN op = new OrganizationsPageN(driver);
		op.clickonCreateOrgLookUpImg();
		
		CreateNewOrganizationPageN cnop = new CreateNewOrganizationPageN(driver);
		cnop.createNewOrganization(ORGNAME);
		
		OrganizationInfoPageN oip = new OrganizationInfoPageN(driver);
		String orgNameCreated = oip.getHeaderText();
		
		Assert.assertTrue(orgNameCreated.contains(ORGNAME));
		System.out.println(orgNameCreated+" Organization created successfully");
		
		
	}

	
	
	
	
	

}
