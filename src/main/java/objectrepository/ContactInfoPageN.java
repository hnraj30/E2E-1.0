package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPageN {
	//Declaration
	@FindBy(id="dtlview_Last Name")
	private WebElement contactHeaderText;
	
	//Initialization
	public ContactInfoPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeaderText()
	{
		return contactHeaderText;
	}
	
	//Business library
	/**
	 * This method captures header text and return it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return contactHeaderText.getText();
	}

}
