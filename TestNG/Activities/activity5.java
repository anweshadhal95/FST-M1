package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class activity5 {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = {"HeaderTests", "ButtonTests"})
    public void titleTest()
    {
        String title=driver.getTitle();
        System.out.println(title);
    }

    @Test (groups = {"HeaderTests"})
    public void headerTest1()
    {
        WebElement element=driver.findElement(By.id("third-header"));
        String headerValue=element.getText();
        Assert.assertEquals("Third header",headerValue);
    }

    @Test (groups = {"HeaderTests"})
    public void headerTest2()
    {
        WebElement element=driver.findElement(By.xpath("//h5[@class=\"ui green header\"]"));
        String headerColorValue=element.getCssValue("color");
        System.out.println(headerColorValue);
        Assert.assertEquals("rgb(33, 186, 69)",headerColorValue);
    }

    @Test (groups = {"ButtonTests"})
    public void buttonTest1()
    {
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (groups = {"ButtonTests"})
    public void buttonTest2()
    {
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
/*
testng.xml FILE

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="ExampleSuite">
    <test thread-count="4" name="SuiteTests">
        <groups>
            <run>
                <include name="HeaderTests"></include>
                <include name="ButtonTests"></include>
            </run>
        </groups>
        <classes>
                <class name="activities.activity5"></class>
                <class name="activities.suiteExample.DemoOne"></class>
                <class name="activities.suiteExample.DemoTwo"></class>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->


 */
