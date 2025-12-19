package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import objectrepository.CreateNewOrganizationPageN;
import objectrepository.HomePageN;
import objectrepository.OrganizationInfoPageN;
import objectrepository.OrganizationsPageN;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateMultipleOrgWithIndustryTest extends BaseClass{
	
	@Test(dataProvider="getData",groups= {"RegressionSuite"})
	public void createMultipleOrgWithIndustryTest(String orgName, String indType)
	{
		//Read all required data
		//ExcelFileUtility eUtil = new ExcelFileUtility();--Not required Inheriting from Base Class
		//JavaUtility jUtil = new JavaUtility();--Not required Inheriting from Base Class
			
		String ORGNAME = orgName+jUtil.getRandomNumber();
		String INDTYPE = indType;
		System.out.println("Data Provider values:	OrgName: "+orgName+"	IndType: "+indType);
		System.out.println(ORGNAME);
		System.out.println(INDTYPE);
		
		
		//Click on Organization link
		HomePageN hp = new HomePageN(driver);
		hp.clickOnOrgLink();
		
		//Click on Create New Organization lookup icon
		OrganizationsPageN op = new OrganizationsPageN(driver);
		op.clickonCreateOrgLookUpImg();
		
		//Create new organization with industry type
		CreateNewOrganizationPageN cnop = new CreateNewOrganizationPageN(driver);
		cnop.createNewOrganization(ORGNAME, INDTYPE);
		
		
		
		//Validate Orgname created
		OrganizationInfoPageN oip = new OrganizationInfoPageN(driver);
		String OrgHeadertext = oip.getHeaderText();
		
		Assert.assertEquals(ORGNAME, OrgHeadertext);
		
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleData("MultipleOrganizations");
	}
}
