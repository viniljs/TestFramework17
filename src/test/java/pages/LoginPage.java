package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Web;

public class LoginPage extends BasePage{

	// Locators
	@FindBy(id="username")
	private WebElement username;   // driver.findElement(By.xpath())
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Business logic
	public void peformLogin(String userName,String password) {
		this.username.sendKeys(userName);
		this.password.sendKeys(password);
		btnLogin.click();
	}
	
	
	
	
}
