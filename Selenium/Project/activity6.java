import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity6 {
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
    public void testLogin()
    {
        WebElement menuMyAccount=driver.findElement(By.xpath("//li[@id=\"menu-item-1507\"]/a"));
        String menuMyAccountText=menuMyAccount.getText();
        //System.out.println(menuMyAccountText);
        menuMyAccount.click();
        System.out.println(driver.getTitle());
        Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a"));
        //System.out.println(loginButton.getText());
        loginButton.click();
        WebElement userName=driver.findElement(By.id("user_login"));
        userName.sendKeys("root");
        WebElement passWord1=driver.findElement(By.id("user_pass"));
        passWord1.sendKeys("pa$$w0rd");
        //passWord.sendKeys("pa$$w0rd");
        WebElement loginBtn1=driver.findElement(By.id("wp-submit"));
        loginBtn1.click();
        //System.out.println(driver.getTitle());
        Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
