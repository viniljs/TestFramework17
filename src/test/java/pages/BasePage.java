package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebElement waitForElement(WebDriver driver,WebElement ele, long timeout) { // 25 
		return new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForAlert(WebDriver driver, long timeout) { // 25 
		new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void performScrollToElement(WebDriver driver, WebElement element) { 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	

}
