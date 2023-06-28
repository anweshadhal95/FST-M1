import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity4 {
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
        WebElement secondPopularCourse=driver.findElement(By.xpath("//div[@class=\"ld-course-list-items row\"]/div[2]/article/div[@class=\"caption\"]/h3"));
        String secondPopularCourseText=secondPopularCourse.getText();
        System.out.println(secondPopularCourseText);
        Assert.assertEquals("Email Marketing Strategies",secondPopularCourseText);
    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
