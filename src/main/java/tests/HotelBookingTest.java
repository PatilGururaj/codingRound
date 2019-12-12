package tests;

import pages.HotelBookingPage;
import utiity.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBookingTest extends Base{


    @Test
    public void shouldBeAbleToSearchForHotels() {
          	
    	HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
    	navigateToApplication("https://www.cleartrip.com/");
    	hotelBookingPage.searchHotels("Indiranagar, Bangalore", "1 room, 2 adults");
    	Boolean flag = hotelBookingPage.verifySearchResult("Indiranagar, Bangalore");
        Assert.assertTrue(flag);
    }

}
