package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavPage extends BasePage{
	
	// locators
	@FindBy(xpath=".//a[text()='Employee Details']")
	private WebElement tabEmpDetails;
	
	
	private WebDriver driver;
	
	public TopNavPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void navToEmpDetailsPage() {
		tabEmpDetails.click();
	}
	
	public void navToProjectDetailsPage() {
			
	}
	
	public void navToWeeklyStatusPage() {
		
	}

}
