package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity2 {

    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/login-form");
        System.out.println("The title of the page is: "+driver.getTitle());
        WebElement userName=driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        WebElement passWord=driver.findElement(By.id("password"));
        passWord.sendKeys("password");
        WebElement logIn=driver.findElement(By.xpath("//button[contains(text(),\"Log in\")]"));
        logIn.click();
        driver.close();
    }

}
