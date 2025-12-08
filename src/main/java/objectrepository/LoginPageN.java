package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class LoginPageN {//Rule 1
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;

	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@Type='submit']")})
	private WebElement loginBtn;
	
	//Initialization
	public LoginPageN(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}
	
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	
	//Buisiness library
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
}


