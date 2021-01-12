package core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web {
	
	public static void setText(WebDriver driver,String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static void setText(WebDriver driver,WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	public static void selectValue(WebElement select, String value) {
		Select sel = new Select(select);
		sel.selectByValue(value);
	}
	
	public static void setText(WebDriver driver,By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void click(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void click(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	
	public static String grabText(WebDriver driver,String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static void selectOption(WebElement ele,String text) {
		Select sel = new Select(ele);
		sel.selectByValue(text);
	}
	
	public static WebElement waitForElement(WebDriver driver,String xpath, long timeout) { // 25 
		return new WebDriverWait(driver,timeout)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
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
