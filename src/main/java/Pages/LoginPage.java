package Pages;

import Utilities.BaseDriver;
import Utilities.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseDriver {

    @FindBy(name = "userName")
    private WebElement userNameTextField;

    @FindBy(name = "password")
    private WebElement passwordTextField;

    @FindBy(name = "submit")
    private WebElement submitButton;


    public LoginPage(Browser browser){
        super(browser);
        PageFactory.initElements(this.getDriver(), this);
    }

    public void login(String username, String password){
        this.userNameTextField.sendKeys(username);
        this.passwordTextField.sendKeys(password);
        this.submitButton.click();
    }
}
