package leadTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import objectrepository.CreateNewLeadPageN;
import objectrepository.HomePageN;
import objectrepository.LeadsInfoPageN;
import objectrepository.LeadsPageN;

@Listeners(genericUtilities.ListenersImplementationClass.class)

public class CreateLeadsTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createLeadWithMandatoryFields() throws EncryptedDocumentException, IOException
	{
		//Create object for all required utility classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//Read all required data
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2)+jUtil.getRandomNumber();
		String COMPANY = eUtil.readDataFromExcelFile("Leads", 1, 3)+jUtil.getRandomNumber();
		
		//Click on Leads Link
		HomePageN hp = new HomePageN(driver);
		hp.clickOnLeadLink();
		Reporter.log("Clicked on lead link");
		
		//Click on CreateLead look up icon
		LeadsPageN lp = new LeadsPageN(driver);
		lp.clickOnCreateLeadBtn();
		Reporter.log("Clicked on Create lead lookup icon");

		//Create new leads
		CreateNewLeadPageN cnlp = new CreateNewLeadPageN(driver);
		cnlp.createLeads(LASTNAME, COMPANY);
		Reporter.log("Lead created");
		//Assert.fail();
		
		//Validate newly created lead name
		LeadsInfoPageN lip = new LeadsInfoPageN(driver);
		String leadNameFromHeader = lip.getLastNameHeader().getText();
		Assert.assertEquals(LASTNAME,leadNameFromHeader);
		System.out.println(leadNameFromHeader+" lead created");
		Reporter.log("Lead vaidated");
		

	}
	
	@Test(groups={"RegressionSuite"})
	public void createLeadWithLeadSource() throws EncryptedDocumentException, IOException
	{
		//Create objects for all required utility classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String LASTNAME  = eUtil.readDataFromExcelFile("Leads", 7, 2)+jUtil.getRandomNumber();
		String COMPANY  = eUtil.readDataFromExcelFile("Leads", 7, 3)+jUtil.getRandomNumber();
		String LEAD_SOURCE  = eUtil.readDataFromExcelFile("Leads", 7, 4);
		
		//Click on leads link
		HomePageN hp = new HomePageN(driver);
		hp.clickOnLeadLink();
		Reporter.log("Clicked on leads link");
		
		//Click on create new lead look up icon
		LeadsPageN lp = new LeadsPageN(driver);
		lp.clickOnCreateLeadBtn();
		Reporter.log("Clicked on create new lead link");

		//Create new lead with LASTNAME, COMPANY and LEAD SOURCE
		CreateNewLeadPageN cnlp = new CreateNewLeadPageN(driver);
		cnlp.createLeadWithLeadSource(LASTNAME, COMPANY, LEAD_SOURCE);
		Reporter.log("Lead created with lead source");

		//Validate lead from header text
		LeadsInfoPageN lip = new LeadsInfoPageN(driver);
		String lastNameFromHeader = lip.getLastNameHeader().getText();
		Assert.assertEquals(LASTNAME, lastNameFromHeader);
		System.out.println(lastNameFromHeader+" lead created");
		Reporter.log(lastNameFromHeader+"Lead validated");
		
	}
	
	@Test(groups={"RegressionSuite"})
	public void createLeadWithLeadSourceAndIndustry() throws EncryptedDocumentException, IOException
	{
		//Create object for all required Utility classes
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String LASTNAME  = eUtil.readDataFromExcelFile("Leads", 10, 2)+jUtil.getRandomNumber();
		String COMPANY  = eUtil.readDataFromExcelFile("Leads", 10, 3)+jUtil.getRandomNumber();
		String LEAD_SOURCE  = eUtil.readDataFromExcelFile("Leads", 10, 4);
		String INDUSTRY  = eUtil.readDataFromExcelFile("Leads", 10, 5);

		//Click on leads link
		HomePageN hp = new HomePageN(driver);
		hp.clickOnLeadLink();
		Reporter.log("Clicked on leads link");
		
		//Click on create new lead look up icon
		LeadsPageN lp = new LeadsPageN(driver);
		lp.clickOnCreateLeadBtn();
		Reporter.log("Clicked on create new lead link");

		//Create new lead with LASTNAME, COMPANY, LEAD SOURCE and INDUSTRY
		CreateNewLeadPageN cnlp = new CreateNewLeadPageN(driver);
		cnlp.createLeadWithLeadSourceAndIndustry(LASTNAME, COMPANY, LEAD_SOURCE, INDUSTRY);
		
		Reporter.log("Lead created with last name, company, lead source and Industry");

		//Validate lead from header text
		LeadsInfoPageN lip = new LeadsInfoPageN(driver);
		String lastNameFromHeader = lip.getLastNameHeader().getText();
		Assert.assertEquals(LASTNAME, lastNameFromHeader);
		
		System.out.println(lastNameFromHeader+" lead created");
		Reporter.log(lastNameFromHeader+"Lead validated");
	}
	
	
	

}
