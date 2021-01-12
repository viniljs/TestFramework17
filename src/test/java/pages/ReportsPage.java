package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Web;

public class ReportsPage extends BasePage{
	
	// locators
	@FindBy(xpath=".//input[@id='empid']/following-sibling::input[@type='button']")
	private WebElement btnSelectEmp;
	
	@FindBy(xpath=".//input[@value='View Report']")
	private WebElement btnViewReport;
	
	@FindBy(id="selEmployeeId")
	private WebElement selEmployee;
	
	@FindBy(xpath=".//td[text()='No Rows Found']")
	private WebElement emptyReport;
	
	private WebDriver driver;
	
	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// business logic
	public boolean viewNoReportFound(String empValue) {
		btnSelectEmp.click();
		Web.selectOption(selEmployee, empValue);
		btnViewReport.click();
		if(emptyReport.isDisplayed()) {
			return true;
		}
		return false;
	}
	
}
