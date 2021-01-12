package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage extends BasePage{

	
	// locators
	@FindBy(xpath=".//table[@class='wpn_content']//table//tr[3]/td[3]")
	private WebElement firstEmpEmail;
	
	@FindBy(xpath=".//table[@class='wpn_content']//table//tr[3]/td[6]/a")
	private WebElement firstEmpDelete;
	
	@FindBy(xpath=".//table[@class='wpn_content']//table//td[3][contains(text(),'@')]")
	private List<WebElement> empList;
	
	private WebDriver driver;
	
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public boolean checkDeleteEmployee() {
		String empEmail = firstEmpEmail.getText();
		firstEmpDelete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String newEmpEmail = firstEmpEmail.getText();
		if(empEmail.equals(newEmpEmail)) {return false;} return true;
	}
	
	public void deleteAllEmp() {
		for(WebElement ele : empList) {
			
		}
	}
}
