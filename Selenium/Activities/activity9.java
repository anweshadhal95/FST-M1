package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity9 {

    public static void main(String[] args) {

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/ajax");
        driver.findElement(By.cssSelector("button.violet")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);

        WebElement element = driver.findElement(By.tagName("h3"));
        System.out.println(element.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String element1 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(element1);
        driver.close();
    }
}
