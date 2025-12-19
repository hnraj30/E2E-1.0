package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPageN {
	//Declaration
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameHeader;
	
	//Initialization
	public LeadsInfoPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameHeader()
	{
		return lastNameHeader;
	}
	
	

}
