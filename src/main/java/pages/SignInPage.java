/**
 * g.patil
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	public void SingInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public String signIn(){
		linkYourTrips.click();
		linkSignIn.click();
		String frameName = frameElement.getAttribute("name");
		driver.switchTo().frame(frameName);
		btnSignIn.click();
		String errorDetails = driver.findElement(By.id("errors1")).getText();
		return errorDetails;
	}
}
