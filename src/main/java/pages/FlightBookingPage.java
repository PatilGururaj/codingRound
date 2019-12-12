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
	
	/**
	 * This method is used to search the flights
	 * @param src
	 * @param dest
	 */
	public void searchForOneWayFlights(String src, String dest){
		WaitHelper wait = new WaitHelper(driver);
		wait.waitElementTobeClickable(driver, radioButtonOneWay, 20).click();
		
		//Enter the Origin location details 
		txtBoxFrom.clear();
		txtBoxFrom.sendKeys(src);
		WebElement originOptionElement = wait.setExplicitWait(driver, By.id("ui-id-1"), 20);
		List<WebElement> originOptions = originOptionElement.findElements(By.tagName("li"));
		originOptions.get(0).click();
		
		//Enter the Destination location details
		txtBoxTo.clear();
		txtBoxTo.sendKeys(dest);
		WebElement destinationOptionElement = wait.setExplicitWait(driver, By.id("ui-id-2"),20);
		List<WebElement> destinationOptions = destinationOptionElement.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		
		datePicker.click();
		btnSearchFlights.click();
	}
	
	/**
	 * This method verifies that your search summary has the source and destination
	 * @param src
	 * @param dest
	 * @return
	 */
	public Boolean verifySearchResults(String src, String dest){
		WebElement searchSummary = driver.findElement(By.xpath("//div[@class='searchSummary']/strong"));
		String searchResult = searchSummary.getText();
		if (searchResult.contains(src) && searchResult.contains(dest)){
			System.out.println(searchResult + " has "+ src + " and "+ dest);
			return true;
		}else
		{
		return false;
		}
	}
	

}
