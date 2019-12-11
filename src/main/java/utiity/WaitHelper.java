/**
 * g.patil
 */
package utiity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author g.patil
 *
 */
public class WaitHelper {
	
	private WebDriver driver;

	/**
	 * @param driver
	 */
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This is ImplicitWait method
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit){
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	/**
	 * This is ExplicitWait method
	 * @param driver
	 * @param by
	 */
	public WebElement setExplicitWait(WebDriver driver, By by){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	/**
	 * This is ExplicitWait method
	 * @param driver
	 * @param element
	 */
	public WebElement waitElementTobeClickable(WebDriver driver, WebElement element, int timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
}
