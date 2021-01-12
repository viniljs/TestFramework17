package tests;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import core.DriverFactory;
import core.ExcelDataProvider;
import core.TestConfig;
import core.TestReports;

public class TestBase {
	
	private WebDriver driver;
	private DriverFactory df;
	private ExcelDataProvider excel;
	private TestReports reports;
	
	@BeforeSuite
	public void initSuite() throws Exception {
		TestConfig.loadProperies(System.getenv("env"));
		reports =  new TestReports();
	}
	
	@DataProvider
	public Object[][] extractData(Method method) throws Exception {
		String tcName = method.getName();
		excel = new ExcelDataProvider(System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx",System.getenv("env").toUpperCase());
		List<HashMap<String,String>> data = excel.getAllData(tcName);
		
		Object[][] dataObj = new Object[data.size()][1];
		for(int i=0; i<data.size(); i++) {
			dataObj[i][0] = data.get(i);
		}
		return dataObj;
	}
	
	@BeforeClass(alwaysRun=true)
	public void initDriver() throws Exception {
		String browser = System.getenv("browser");
		df = new DriverFactory();
		driver = df.getDriver(browser);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		df.tearDown();
	}
	
	@BeforeMethod
	public void initTest(Method method) {
		reports.startReport(method.getName());
	}
	
	@AfterMethod
	public void finishTest() {
		reports.endReport();
	}
	
	public WebDriver driver() {
		return driver;
	}
	
	public TestReports report() {
		return reports;
	}
	
	@AfterSuite
	public void quitSuite() {
		reports.clearReport();
	}

}
