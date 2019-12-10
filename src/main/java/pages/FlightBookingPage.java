/**
 * g.patil
 */
package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class FlightBookingPage {
	
	private WebDriver driver;
	
	@FindBy(id="OneWay")
	WebElement radioButtonOneWay;
	
	@FindBy(id="FromTag")
	WebElement txtBoxFrom;
	
	@FindBy(id="ToTag")
	WebElement txtBoxTo;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']")
	WebElement dDowndestOptions;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	WebElement datePicker;
	
	@FindBy(id="SearchBtn")
	WebElement btnSearchFlights;
	
	
	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchForOneWayFlights(String src, String dest){
		radioButtonOneWay.click();
		txtBoxFrom.clear();
		txtBoxFrom.sendKeys(src);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
		
		txtBoxTo.clear();
		txtBoxTo.sendKeys(dest);
		waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		
		datePicker.click();
		btnSearchFlights.click();
	}
	
	public Boolean verifySearchResults(String src, String dest){
		WebElement searchSummary = driver.findElement(By.xpath("//div[@class='searchSummary']/strong"));
		String searchResult = searchSummary.getText();
		if (searchResult.contains(src) && searchResult.contains(dest)){
			return true;
		}else
		{
		return false;
		}
	}
	

}
