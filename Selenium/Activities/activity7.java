package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity7 {
    public static void main(String[] args) {

        WebDriver driver;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("The title of the page is: " + driver.getTitle());
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        Actions builder=new Actions(driver);
        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
        builder.clickAndHold(football).moveToElement(dropzone2).pause(2000).release().build().perform();
        driver.close();
    }
}
