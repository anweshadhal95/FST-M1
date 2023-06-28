package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity2 {

    AndroidDriver driver;

    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void AddNote() {
        // Perform the calculation
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement title=driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        title.click();
        title.sendKeys("Test Google Keep");

        WebElement noteText=driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        noteText.click();
        noteText.sendKeys("A small note to test google keep app");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        //editorListView.click();
        title.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement backButton=driver.findElement(AppiumBy.accessibilityId("Navigate up"));
        backButton.click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Test Google Keep')]"));

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
