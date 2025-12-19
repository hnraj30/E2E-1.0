package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;



public class CreateNewLeadPageN extends WebDriverUtility{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="company")
	private WebElement companyEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDD;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	//Initialization
	public CreateNewLeadPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getlAstNameEdt()
	{
		return lastNameEdt;
	}
	
	public WebElement getCompanyeEdt()
	{
		return companyEdt;
	}
	
	public WebElement getSavebtn()
	{
		return saveBtn;
	}
	
	public WebElement getLeadSourceDD()
	{
		return leadSourceDD;
	}
	
	public WebElement getIndustryDD()
	{
		return industryDD;
	}
	
	//Business library
	/**
	 * This method will create lead with mandatory fields
	 * @param LASTNAME
	 * @param COMPANY
	 */
	public void createLeads(String LASTNAME, String COMPANY)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		saveBtn.click();
	}
	
	/**
	 * This method creates a lead with mandatory fields and lead source
	 * @param LASTNAME
	 * @param COMPANY
	 * @param LEADSOURCE
	 */
	public void createLeadWithLeadSource(String LASTNAME, String COMPANY, String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		handleDropDown(leadSourceDD, LEADSOURCE);
		saveBtn.click();
	}

	/**
	 * This method creates a lead with LASTNAME, COMPANY, LEADSOURCE and INDUSTRY
	 * @param LASTNAME
	 * @param COMPANY
	 * @param LEADSOURCE
	 * @param INDUSTRY
	 */
	public void createLeadWithLeadSourceAndIndustry(String LASTNAME, String COMPANY, String LEADSOURCE,String INDUSTRY)
	{
		lastNameEdt.sendKeys(LASTNAME);
		companyEdt.sendKeys(COMPANY);
		handleDropDown(leadSourceDD, LEADSOURCE);
		handleDropDown(industryDD, INDUSTRY);
		saveBtn.click();
	}
	
}
