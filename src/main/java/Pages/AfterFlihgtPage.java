package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterFlihgtPage extends BaseDriver {

    @FindBy(css = "p[align='left']")
    private WebElement confirmationMessage;
    public AfterFlihgtPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.getDriver(),this);
    }

    public boolean isInPage(){
        return confirmationMessage.getText().contains("No Seats");
    }
}
