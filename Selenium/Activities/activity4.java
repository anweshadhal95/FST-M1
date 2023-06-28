package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4 {

    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/target-practice");
        System.out.println("The title of the page is: "+driver.getTitle());
        WebElement element=driver.findElement(By.xpath("//h3[@id=\"third-header\"]"));
        System.out.println("The 3rd header on the page is: "+element.getText());
        WebElement headerElement=driver.findElement(By.xpath("//h5[contains(text(),\"Fifth header\")]"));
        System.out.println("The 5th header color is:"+ headerElement.getCssValue("color"));
        WebElement violetButton=driver.findElement(By.xpath("//button[contains(text(),\"Violet\")]"));
        System.out.println("All classes of violet button: "+ violetButton.getAttribute("class"));
        WebElement greyButton=driver.findElement(By.xpath("//button[contains(text(),\"Grey\")]"));
        System.out.println(greyButton.getText());
        driver.close();
    }
}
