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
import org.openqa.selenium.support.ui.Select;

import utiity.WaitHelper;

/**
 * @author g.patil
 *
 */
public class HotelBookingPage {
	
	private WebDriver driver;

	/**
	 * @param driver
	 */
	public HotelBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(xpath="//input[@title='Check-in date']")
	private WebElement checkInDate;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	private WebElement currentDate;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-active ']")
	private WebElement nextDate;
	
	@FindBy(xpath="//input[@title='Check-out date']")
	private WebElement checkOutDate;
	
	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	public void searchHotels(String location, String noOfRoomAndTravellers){
		hotelLink.click();
		WaitHelper wait = new WaitHelper(driver);
		wait.waitElementTobeClickable(driver, localityTextBox, 20).click();
		localityTextBox.clear();
		localityTextBox.sendKeys(location);
		
		WebElement allOptions = wait.setExplicitWait(driver, By.xpath("//ul[@id='ui-id-1']"));
		List<WebElement> allOptionsResult = allOptions.findElements(By.xpath("./li"));
		allOptionsResult.get(1).click();
		checkInDate.click();
		currentDate.click();
		wait.waitElementTobeClickable(driver, nextDate, 20).click();
		new Select(travellerSelection).selectByVisibleText(noOfRoomAndTravellers);
        searchButton.click();
	}

	/**
	 * 
	 */
	public Boolean verifySearchResult(String location) {
		Boolean flag = false;
		List<WebElement> searchConfirmation = driver.findElements(By.xpath("//div[@class='row searchWidgetRow propertySection']//strong"));
		for(WebElement eachElement: searchConfirmation){
			if(location.contains(eachElement.getText())){
				flag=true;
			}
		}
		return flag;
	}

}
