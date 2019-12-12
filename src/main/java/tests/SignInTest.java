package tests;

import pages.SignInPage;
import utiity.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends Base{

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	SignInPage signInPage  = new SignInPage(driver);
    	navigateToApplication("https://www.cleartrip.com/");
    	String errors1 = signInPage.signIn();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
    }
}
