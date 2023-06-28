import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class activity7 {
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
        //System.out.println(menuMyAccountText);
        allCourses.click();
        List<WebElement> webElementList=driver.findElements(By.xpath("//div[@class=\"ld-course-list-items row\"]/div"));
        for (int i=0;i<webElementList.size();i++)
        {
            String s="/article/div[@class=\"caption\"]/h3";
            WebElement element=webElementList.get(i);
            System.out.println(element.getText());
        }
        System.out.println("The number of courses are: "+webElementList.size());
    }

    @AfterClass
    public void afterClass()
    {
        driver.close();
    }
}
