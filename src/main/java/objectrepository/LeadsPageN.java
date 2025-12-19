package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPageN {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadBtn;
	
	
	//Initialization
	
	public LeadsPageN(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
 	public WebElement getCreateLeadBtn()
 	{
 		return createLeadBtn;
 	}
	
	//Business library
 	/**
 	 * This method will click on create lead button
 	 */
 	public void clickOnCreateLeadBtn()
 	{
 		createLeadBtn.click();
 	}
	

}
