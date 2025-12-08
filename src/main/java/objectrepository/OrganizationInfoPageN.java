package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPageN {
	//Declaration
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgHeaderText;
	
	//Initialization
	public OrganizationInfoPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgHeaderText()
	{
		return orgHeaderText;
	}
	
	//Business library
	/**
	 * This method will capture header text and returns it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return orgHeaderText.getText();
	}
}
