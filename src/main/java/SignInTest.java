import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        WebDriver driver = setDriverPath();
        driver.manage().window().maximize();

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        List <WebElement> iframes = driver.findElements(By.tagName("iframe"));
        WebElement frameElement = driver.findElement(By.xpath("//div[@id='ModalFrame']//iframe"));
        String frameName = frameElement.getAttribute("name");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameName);
        driver.findElement(By.id("signInButton")).click();

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private WebDriver setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            return new ChromeDriver();   
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            return new ChromeDriver();            
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            return new ChromeDriver();   
        }
        return null;
    }


}
