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

import java.util.List;

public class activity9 {
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
        WebElement allCourses=driver.findElement(By.xpath("//li[@id=\"menu-item-1508\"]/a"));
        String menuMyAccountText=allCourses.getText();
        driver.manage().window().maximize();
        //System.out.println(menuMyAccountText);
        allCourses.click();
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,500)");
        WebElement course1=driver.findElement(By.xpath("//*[@id=\"post-69\"]/div[2]/p[2]/a"));
        course1.click();
        je.executeScript("window.scrollBy(0,1000)");
        //WebElement expanBtn=driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]/div/div/div/span[1]"));
        //expanBtn.click();
        WebElement loginToEnrollBtn=driver.findElement(By.xpath("//*[@class=\"ld-button\"]"));
        loginToEnrollBtn.click();
        WebElement userName=driver.findElement(By.id("user_login"));
        userName.sendKeys("root");
        WebElement passWord=driver.findElement(By.id("user_pass"));
        passWord.sendKeys("pa$$w0rd");
        WebElement loginBtn=driver.findElement(By.id("wp-submit"));
        loginBtn.click();
        je.executeScript("window.scrollBy(0,1200)");
        WebElement developingStrategyCourse = driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]/div[1]/a/div[2]"));
        developingStrategyCourse.click();
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Developing Strategy – Alchemy LMS",title);
    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
