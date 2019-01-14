package plastiq.qa_challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends App
{
	@FindBy(css = "input[title='Search']")
    public By searchBox;

    	@Test
    	public void googleTest() {
    		String driverLocation = "C:\\Users\\santhosh.prahladan\\eclipse-workspace\\qa-challenge\\src\\resources\\Drivers";
    		System.setProperty("webdriver.chrome.driver", driverLocation + "/chromedriver.exe");
    		// Initialize browser
    		WebDriver driver=new ChromeDriver();
    		 
    		// Open Google
    		driver.get("http://www.google.com");
    		driver.findElement(By.cssSelector("input[title='Search']")).clear();
    		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("test automation is awesome");
    		
    		driver.findElement(By.cssSelector("input[title='Search']")).submit();
    		System.out.println(driver.getTitle());
    		
    		// Close browser
    		driver.close();
    	}
    

    
}
