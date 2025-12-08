package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPageN {
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//Initialization
	public OrganizationsPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOrgLookUpImg()
	{
		return createOrgLookUpImg;
	}
	
	//Business library
	/**
	 * This method will click on createOrgLookUpImg
	 */
	public void clickonCreateOrgLookUpImg()
	{
		createOrgLookUpImg.click();
	}
	
	

}
