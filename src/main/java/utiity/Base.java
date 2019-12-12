/**
 * g.patil
 */
package utiity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * @author g.patil
 *
 */
public class Base {
		
	
	public WebDriver driver;
		
	@BeforeClass
	public void beforeClass(){
		driver = setUpDriver();
	}
	
	/**
	 * Setting up the driver with required capabilities
	 * @return
	 */
	public WebDriver setUpDriver(){
		driver = getChromeBrowserInstance(setChromeOptions());
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * This method helps to set the chromeOptions
	 * @return
	 */
	public ChromeOptions setChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-popup-blocking");
		options.setCapability(ChromeOptions.CAPABILITY, DesiredCapabilities.chrome());
		return options;
	}
	
	/**
	 * This method helps to get the ChromeInstance
	 * @return
	 */	
	public WebDriver getChromeBrowserInstance(ChromeOptions cap){
		if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            return new ChromeDriver(cap);   
        }
        if (System.getProperty("os.name").contains("Window")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            return new ChromeDriver(cap);            
        }
        if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            return new ChromeDriver(cap);   
        }
        return null;
	}
	
	/**	
	 * This method is to navigate to specific URL
	 * @param Url
	 */
	public void navigateToApplication(String Url){
		driver.get(Url);
	}
	
	/**
	 * After class method to close the browser instance
	 */
	@AfterClass
	public void afterTest(){
		if(driver!=null){
			driver.quit();
		}
	}

}
