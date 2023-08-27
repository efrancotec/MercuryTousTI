package Test;

import Utilities.BaseDriver;
import Utilities.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.Time;

public class ParallelTesting {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver;
        BaseDriver bs = new BaseDriver(Browser.Chrome);
        driver = bs.getDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(10000);
        Assert.assertTrue(true);
        bs.quit();
    }

    @Test
    public void atest2() throws InterruptedException {

        WebDriver driver;
        BaseDriver bs = new BaseDriver(Browser.Firefox);
        driver = bs.getDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(10000);
        Assert.assertTrue(true);
        bs.quit();
    }

}
