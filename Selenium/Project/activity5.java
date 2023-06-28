import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity5 {
    WebDriver driver;

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
        WebElement menuMyAccount=driver.findElement(By.xpath("//li[@id=\"menu-item-1507\"]/a"));
        String menuMyAccountText=menuMyAccount.getText();
        //System.out.println(menuMyAccountText);
        menuMyAccount.click();
        System.out.println(driver.getTitle());
        Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
