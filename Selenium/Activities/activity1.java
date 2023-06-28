package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity1 {


    static WebDriverWait wait;
    public static void main(String[] arg)
    {
        WebDriver driver;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();

        driver.get("https://training-support.net");
        wait= new WebDriverWait(driver,Duration.ofSeconds(8));
        System.out.println("Title of the page is: "+driver.getTitle());
        //driver.close();
        WebElement element=driver.findElement(By.id("about-link"));
        element.click();
        wait= new WebDriverWait(driver,Duration.ofSeconds(8));
        System.out.println("Title of the page is: "+driver.getTitle());
        driver.close();
    }
}
