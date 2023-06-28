import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass()
    public void beforeClass()
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms\n");
    }

    @Test
    public void test1()
    {
        WebElement allCourses=driver.findElement(By.xpath("//li[@id=\"menu-item-1508\"]/a"));
        String menuMyAccountText=allCourses.getText();
        //System.out.println(menuMyAccountText);
        allCourses.click();
        WebElement clickContact=driver.findElement(By.xpath("//li[@id=\"menu-item-1506\"]/a"));
        clickContact.click();
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,800)");
        WebElement fullName=driver.findElement(By.id("wpforms-8-field_0"));
        fullName.sendKeys("Anwesha Dhal");
        WebElement email=driver.findElement(By.id("wpforms-8-field_1"));
        email.sendKeys("abc@gmail.com");
        WebElement subject=driver.findElement(By.id("wpforms-8-field_3"));
        subject.sendKeys("About course Fees");
        WebElement comment=driver.findElement(By.id("wpforms-8-field_2"));
        comment.sendKeys("Need to understand the course fee for Social media marketing");
        WebElement submitBtn=driver.findElement(By.id("wpforms-submit-8"));
        submitBtn.click();
        //wait.withTimeout(Duration.ofSeconds(15));
        WebElement textSuccessPage=driver.findElement(By.xpath("//div[@id=\"wpforms-confirmation-8\"]/p"));
        System.out.println("The message on the success page is: "+textSuccessPage.getText());

    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
