package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPageN extends WebDriverUtility{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement organizationLookUpImg;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Locators for child window elements
	@FindBy(name="search_text")
	private WebElement organizationSearchEdt;
	
	@FindBy(name="search")
	private WebElement organizationSearchBtn;
	
	//initialization
	public CreateNewContactPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameEdt()
	{
		return lastNameEdt;
	}
	public WebElement getOrganizationLookUpImg()
	{
		return organizationLookUpImg;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	public WebElement getOrganizationSearchEdt()
	{
		return organizationSearchEdt;
	}
	public WebElement getOrganizationSearchBtn()
	{
		return organizationSearchBtn;
	}
	
	//Business library
	/**
	 * This method will create new contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewcontact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewcontact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		organizationLookUpImg.click();
		switchToWindow(driver, "Accounts");
		organizationSearchEdt.sendKeys(ORGNAME);
		organizationSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
}
