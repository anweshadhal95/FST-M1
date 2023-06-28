package activity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class activity3 {

        AndroidDriver driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            // Desired Capabilities
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.calculator2");
            options.setAppActivity(".Calculator");
            options.noReset();

            URL serverURL = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(serverURL, options);
        }
    //Test method for addition
    @Test
    public void additionTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        Assert.assertEquals(result, "14");
    }

    // Test method for subtraction
    @Test
    public void subtractTest() {

        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        Assert.assertEquals(result, "5");
    }

    // Test method for multiplication
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        Assert.assertEquals(result, "500");
    }

    //Test method for division
    @Test
    public void divideTest() {

        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        Assert.assertEquals(result, "25");
    }

        @AfterClass
        public void tearDown() {
            // Close the app
            driver.quit();
        }

}
