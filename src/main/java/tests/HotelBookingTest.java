package tests;

import pages.HotelBookingPage;
import utiity.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBookingTest extends Base{

   /* WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;*/

    @Test
    public void shouldBeAbleToSearchForHotels() {
        
    	
    	
    	/*setDriverPath();

        driver.get("https://www.cleartrip.com/");
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();*/
    	
    	HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
    	navigateToApplication("https://www.cleartrip.com/");
    	hotelBookingPage.searchHotels("Indiranagar, Bangalore", "1 room, 2 adults");
    	Boolean flag = hotelBookingPage.verifySearchResult("Indiranagar, Bangalore");
        Assert.assertTrue(flag);
    	driver.quit();

    }

    /*private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }*/

}
