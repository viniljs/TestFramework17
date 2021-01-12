package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.TestConfig;
import core.TestReports;
import pages.EmployeeDetailsPage;
import pages.LoginPage;
import pages.ReportsPage;
import pages.TopNavPage;

public class TestTimeSheetApp extends TestBase{
	LoginPage login;
	ReportsPage reports;
	TopNavPage topnav;
	EmployeeDetailsPage empdetail;
	
	@BeforeMethod
	public void Login_To_App() {
		
		driver().get(TestConfig.getProperty("APP_URL"));
	}
	
	@Test(dataProvider="extractData",priority=1)
	public void Verify_No_Reports_Found_Display_Text(HashMap<String,String> data) {
		login = new LoginPage(driver());
		report().logReport(LogStatus.INFO, "Application Launched", "Application launch successfull");
		
		login.peformLogin(data.get("username"),data.get("password"));
		report().logReport(LogStatus.INFO, "Login Successfull", "Login successfull");
		
		reports = new ReportsPage(driver());
		if(reports.viewNoReportFound(data.get("empvalue")) == true) {
			report().logReport(LogStatus.PASS, "View No Report Error status", 
					"View No Report Error status displayed successfully");
		}else {
			report().logReport(LogStatus.FAIL, "View No Report Error status", 
					"View No Report Error status didnt displayed");
		}
	}
	
	
	@Test(dataProvider="extractData",priority=2)
	public void Verify_Delete_EmployeeSuccessfull(HashMap<String,String> data) {
		login = new LoginPage(driver());
		login.peformLogin(data.get("username"),data.get("password"));
		topnav = new TopNavPage(driver());
		topnav.navToEmpDetailsPage();
		empdetail = new EmployeeDetailsPage(driver());
		Assert.assertEquals(empdetail.checkDeleteEmployee(), 
				true, "Validation failed for delete employee");	
	}
	
	

}
