package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class activity6 {

    WebDriver driver;

    @BeforeClass()
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username","password"})
    public void testMethod(String username,String password)
    {
        WebElement userName=driver.findElement(By.id("username"));
        userName.sendKeys(username);
        WebElement passWord=driver.findElement(By.id("password"));
        passWord.sendKeys(password);
        WebElement loginButton=driver.findElement(By.xpath("//button[@class=\"ui button\"]"));
        loginButton.click();
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
        <parameter name="username" value="admin"></parameter>
        <parameter name="password" value="password"></parameter>
        <classes>
                <class name="activities.activity6"></class>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
 */