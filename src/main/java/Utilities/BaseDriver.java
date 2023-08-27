package Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    private WebDriver driver;
    private Browser browser;

    public BaseDriver(Browser browser){
        this.browser = browser;
        this.setDriver();
    }
    public BaseDriver(WebDriver driver){
        this.driver = driver;
    }

    //NAVIGATION METHODS
    public void goTo(String url){
        this.driver.get(url);
    }
    public void maxScreen(){
        this.driver.manage().window().maximize();
    }

    // DRIVER MANAGED
    public void close(){
        this.driver.close();
    }
    public void quit(){
        this.driver.quit();
    }
    public WebDriver getDriver(){
        return  this.driver;
    }
    public String getTitle(){
        return this.driver.getTitle();
    }
    public String getUrl(){
        return this.driver.getCurrentUrl();
    }

    // ELEMENTS
    public void typeText(By locator, String text){
        this.driver.findElement(locator).sendKeys(text);
    }
    public void clickOn(By locator){
        this.driver.findElement(locator).click();
    }

    // WAITERS
    public void implicitWait(int time){
        this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public void explicitWait(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void explicitWait(By locator, int time){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(locator)));
    }

    public void selectByText(WebElement selectElement, String visibleText){
        Select select = new Select(selectElement);
        select.selectByVisibleText(visibleText);
    }
    public void selectByIndex(WebElement selectElement, int index){
        Select select = new Select(selectElement);
        select.selectByIndex(index);
    }


    // PRIVATE METHODS
    private void setDriver(){

        String basePath = "./src/Drivers/";
         switch (browser){
             case Chrome: {
                 System.setProperty("webdriver.chrome.driver", basePath + "chromedriver.exe");
                 this.driver = new ChromeDriver();
                 break;
             }
             case Firefox: {
                 System.setProperty("webdriver.gecko.driver", basePath + "geckodriver.exe");
                 this.driver = new FirefoxDriver();
                 break;
             }
         }
    }
}
