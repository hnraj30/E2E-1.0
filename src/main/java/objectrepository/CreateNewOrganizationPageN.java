package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPageN extends WebDriverUtility{
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt()
	{
		return orgNameEdt;
	}
	public WebElement getIndustryDD()
	{
		return industryDD;
	}
	public WebElement getTypeDD()
	{
		return typeDD;
	}
	
	public WebElement getaveBtn()
	{
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will create a new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with Org name and Industry Type
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDD, INDUSTRY);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with orgname, industry and type 
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDD, INDUSTRY);
		handleDropDown(industryDD, TYPE);
		saveBtn.click();
		
	}
}
