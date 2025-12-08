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

public class CreateOrganizationWithIndustryTest extends BaseClass{
	@Test(groups="RegressionSuite")
	public void createOrganizationWithIndustryTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtil.readDataFromExcelFile("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelFile("Organization", 4, 3);
		
		
		HomePageN hp = new HomePageN(driver);
		hp.clickOnOrgLink();
		
		OrganizationsPageN op = new OrganizationsPageN(driver);
		op.clickonCreateOrgLookUpImg();
		
		CreateNewOrganizationPageN cnop = new CreateNewOrganizationPageN(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		OrganizationInfoPageN oip = new OrganizationInfoPageN(driver);
		String orgNameCreated = oip.getHeaderText();
		System.out.println(orgNameCreated);
		
		
		Assert.assertTrue(orgNameCreated.contains(ORGNAME));
		System.out.println(orgNameCreated+"Organization created successfully");
		
	}
	

}
