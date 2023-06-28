package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity5 {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("The title of the page is: "+driver.getTitle());
        Actions builder=new Actions(driver);
        builder.click().pause(1000).build().perform();
        WebElement frontText= driver.findElement(By.xpath("//div[@class=\"active\"]"));
        System.out.println(frontText.getText());

        builder.doubleClick().pause(1000).build().perform();
        WebElement frontText1= driver.findElement(By.xpath("//div[@class=\"active\"]"));
        System.out.println(frontText1.getText());

        builder.contextClick().pause(1000).build().perform();
        WebElement frontText2= driver.findElement(By.xpath("//div[@class=\"active\"]"));
        System.out.println(frontText2.getText());

        driver.close();
    }
}
