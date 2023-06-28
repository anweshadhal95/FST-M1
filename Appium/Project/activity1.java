package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void AddTask() throws IOException {
        // Perform the calculation
        WebElement element=driver.findElement(AppiumBy.xpath(
                "//android.widget.LinearLayout[@content-desc=\"Google Tasks\"]/android.widget.TextView"));
        element.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addTaskButton=driver.findElement(AppiumBy.id("tasks_fab"));
        addTaskButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet")));
        WebElement element1=driver.findElement(AppiumBy.className("android.widget.EditText"));
        element1.click();
        element1.sendKeys("Complete Activity with Google Tasks");

        driver.findElement(AppiumBy.id("add_task_done")).click();

        WebElement addTaskButton1=driver.findElement(AppiumBy.id("tasks_fab"));
        addTaskButton1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet")));
        WebElement element2=driver.findElement(AppiumBy.className("android.widget.EditText"));
        element2.click();
        element2.sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();


        WebElement addTaskButton2=driver.findElement(AppiumBy.id("tasks_fab"));
        addTaskButton2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet")));
        WebElement element3=driver.findElement(AppiumBy.className("android.widget.EditText"));
        element3.click();
        element3.sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

//        String str1=driver.findElement(AppiumBy.androidUIAutomator("descriptionContains(\"Complete Activity with Google Tasks\")")).getText();
//        String str2=driver.findElement(AppiumBy.androidUIAutomator("descriptionContains(\"Complete Activity with Google Keep\")")).getText();
//        String str3=driver.findElement(AppiumBy.androidUIAutomator("descriptionContains(\"Complete the second Activity Google Keep\")")).getText();
//        System.out.println(str1+" , "+str2+" , "+str3);
        List<WebElement> list1=driver.findElements(AppiumBy.className("android.widget.TextView"));
        //String task3=list1.get(4).getText();
        //String task2=list1.get(5).getText();
        //String task1=list1.get(6).getText();
        //System.out.println(task3+" , "+task2+" , "+task1);
//        for(WebElement element4 : list1)
//        {
//            System.out.println(element4.getText());
//
//        }
        for(int i=0;i<list1.size();i++)
        {
            WebElement element5=list1.get(i);
            String str=element5.getText();
            //System.out.println("Index:"+i+","+"String:"+str);
            if(i==6)
            {
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                takeScreenshot();
                System.out.println("i==6");
                Assert.assertEquals(str,"Complete the second Activity Google Keep");
                continue;
            }
            if(i==4)
            {
                Assert.assertEquals(str,"Complete Activity with Google Keep");
                System.out.println("i==4");
                continue;
            }
            else if(i==5)
            {
                System.out.println("i==5");
                Assert.assertEquals(str,"Complete Activity with Google Tasks");
                continue;
            }
            else
            {
                continue;
            }

        }

    }

    public void takeScreenshot() throws IOException {

        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenShotName = new File("src/test/resources/screenshot.jpg");
        FileUtils.copyFile(scrShot, screenShotName);
        String filePath = "../" + screenShotName;
        String path = "<img src='" + filePath + "'/>";
        Reporter.log(path);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
