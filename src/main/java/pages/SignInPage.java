/**
 * g.patil
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utiity.WaitHelper;

/**
 * @author g.patil
 *
 */
public class SignInPage {

	private WebDriver driver;
	
	@FindBy(linkText = "Your trips")
	WebElement linkYourTrips;
	
	@FindBy(id="SignIn")
	WebElement linkSignIn;
	
	@FindBy(xpath="//div[@id='ModalFrame']//iframe")
	WebElement frameElement;
	
	@FindBy(id="signInButton")
	WebElement btnSignIn;
	
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	/**
	 * 
	 * @return
	 */
	public String signIn(){
		WaitHelper wait = new WaitHelper(driver);
		wait.waitElementTobeClickable(driver, linkYourTrips, 20).click();
		linkSignIn.click();
		String frameName = frameElement.getAttribute("name");
		driver.switchTo().frame(frameName);
		btnSignIn.click();
		String errorDetails = driver.findElement(By.id("errors1")).getText();
		System.out.println(errorDetails);
		return errorDetails;
	}
}
