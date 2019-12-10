/**
 * g.patil
 */
package utiity;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;


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
	
}
