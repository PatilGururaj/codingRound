package tests;

import pages.FlightBookingPage;
import utiity.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends Base{

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
    	
    	FlightBookingPage flightBooking = new FlightBookingPage(driver);
    	navigateToApplication("https://www.cleartrip.com/");
    	flightBooking.searchForOneWayFlights("Bangalore", "Delhi");    
        Boolean flag = flightBooking.verifySearchResults("Bangalore", "Delhi");
        Assert.assertTrue(flag);
    }

}
