/**
 * g.patil
 */
package utiity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.javafx.PlatformUtil;

/**
 * @author g.patil
 *
 */
public class Base {
	
	public WebDriver driver;
	
	public void setUpDriver(){
		driver = getBrowserInstance();
		driver.manage().window().maximize();
	}
	
	public WebDriver getBrowserInstance(){
		if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            return new ChromeDriver();   
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            return new ChromeDriver();            
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            return new ChromeDriver();   
        }
        return null;
	}

}
