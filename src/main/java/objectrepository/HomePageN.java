 package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePageN extends WebDriverUtility{//Rule 1
	
	//Rule 2: Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;

	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	//Rule 3: Initialization
	public HomePageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//Utilization
	public WebElement getOrganizationsLink()
	{
		return organizationsLink;
	}
	
	public WebElement getContactsLink()
	{
		return organizationsLink;
	}
	public WebElement getLeadsLink()
	{
		return leadsLink;
	}
	public WebElement getProductsLink()
	{
		return productsLink;
	}
	public WebElement getAdminImg()
	{
		return adminImg;
	}
	public WebElement getSignoutLink()
	{
		return signoutLink;
	}
	
	//Business library
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLink.click();
		
	}
	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrgLink()
	{
		organizationsLink.click();
	}
	
	/**
	 * This method will click on Leads link
	 */
	public void clickOnLeadLink()
	{
		leadsLink.click();
	}
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, adminImg);
		Thread.sleep(2000);
		signoutLink.click();
	}
	
	
}
