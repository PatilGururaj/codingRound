/**
 * g.patil
 */
package utiity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

/**
 * @author g.patil
 *
 */
public class Base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUpDriver(){
		driver = getChromeBrowserInstance(setChromeOptions());
		driver.manage().window().maximize();
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
	
		
	public void navigateToApplication(String Url){
		driver.get(Url);
	}

}
