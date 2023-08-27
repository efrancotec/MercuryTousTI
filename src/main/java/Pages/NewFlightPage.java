package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewFlightPage extends BaseDriver {

    @FindBy(css = "input[value='oneway']")
    private WebElement typeRadioButton;
    @FindBy(name = "passCount")
    private WebElement passengersDropDown;
    @FindBy(name = "fromPort")
    private WebElement departingFromDropDown;
    @FindBy(name = "fromMonth")
    private WebElement onDropDown;
    @FindBy(name = "toPort")
    private WebElement arrivingDropDown;
    @FindBy(name = "toMonth")
    private WebElement returningDropDown;
    @FindBy(css = "input[value='Business']")
    private WebElement businessClassRadioButton;
    @FindBy(name = "airline")
    private WebElement airlineDropDown;
    @FindBy(name = "findFlights")
    private WebElement continueButton;

    public NewFlightPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.getDriver(), this);
    }

    public void createNewFlight(){
        typeRadioButton.click();
        this.selectByText(passengersDropDown, "3");
        this.selectByText(departingFromDropDown, "Paris");
        this.selectByText(onDropDown, "May");
        this.selectByText(arrivingDropDown, "New York");
        this.selectByText(returningDropDown, "March");
        businessClassRadioButton.click();
        this.selectByText(airlineDropDown, "Unified Airlines");
        continueButton.click();
    }
}
