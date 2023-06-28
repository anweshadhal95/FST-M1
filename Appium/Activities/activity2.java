package activity;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class activity2 {

    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://www.training-support.net");
    }

    // Test method
    @Test
    public void chromeTest1() {
        // Perform the calculation
        WebElement element=driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='Training Support']"));
                String pageHeading=element.getText();
       System.out.println("Page heading is: "+pageHeading);



        WebElement element1=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']"));
        String aboutUsButton=element1.getText();
        System.out.println("About Us button text: "+aboutUsButton);
        element1.click();

        WebElement element2=driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']"));
        String aboutUsPageText=element2.getText();
        System.out.println("About Us page text: "+aboutUsPageText);

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }

}
