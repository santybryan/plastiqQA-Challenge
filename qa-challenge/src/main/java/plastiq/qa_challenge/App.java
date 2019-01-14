package plastiq.qa_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
	public void enterTextIntoField(WebElement element, String text){
		try {
			
				element.clear();
				element.sendKeys(text);
			
		} catch (StaleElementReferenceException sere) {
			enterTextIntoField(element, text);
		}
	}
	
	public void waitUntilVisible(String element, int maxTimeOut, WebDriver driver) {
		
		Duration sec = Duration.ofSeconds(maxTimeOut);
		FluentWait<WebDriver> checkingVisibility = new FluentWait<WebDriver>(driver)
			.withTimeout(sec)
			.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		checkingVisibility.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(element))));
	}
}
