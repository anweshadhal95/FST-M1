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

public class activity3 {

    WebDriver driver;


    @BeforeClass
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void testCase1()
    {
        WebElement userName=driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        WebElement passWord=driver.findElement(By.id("password"));
        passWord.sendKeys("password");
        WebElement loginButton=driver.findElement(By.xpath("//button[@class=\"ui button\"]"));
        loginButton.click();
        WebElement message=driver.findElement(By.id("action-confirmation"));
        String confirmationMsg= message.getText();
        Assert.assertEquals("Welcome Back, admin",confirmationMsg);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
/*

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="ExampleSuite">
    <test thread-count="4" name="SuiteTests">
        <classes>
                <class name="activities.suiteExample.DemoOne"></class>
                <class name="activities.suiteExample.DemoTwo"></class>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->

 */
