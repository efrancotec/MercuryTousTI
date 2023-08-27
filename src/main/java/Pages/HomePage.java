package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseDriver {

    @FindBy(xpath = "//h3")
    private WebElement loginSuccessMessage;

    @FindBy(css = "a[href='reservation.php']")
    private WebElement flightRegisterLink;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.getDriver(), this);
    }

    public boolean isInHomePage(){
        return loginSuccessMessage.getText().equals("Login Successfully");
    }

    public void goToFlightRegister(){
        this.explicitWait(flightRegisterLink, 15);
        flightRegisterLink.click();
    }
}
