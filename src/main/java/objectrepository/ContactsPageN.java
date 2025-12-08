package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPageN {
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//Initialize
	public ContactsPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilize
	public WebElement getCreateContactLookUpImg()
	{
		return createContactLookUpImg;
	}
	
	//Business library
	/**
	 * This method will click on Create contact look up image
	 */
	public void clickonCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
	}
	
}
