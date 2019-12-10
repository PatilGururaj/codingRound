/**
 * g.patil
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
		txtBoxTo.clear();
		txtBoxTo.sendKeys(dest);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
