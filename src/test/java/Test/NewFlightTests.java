package Test;

import Pages.AfterFlihgtPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewFlightPage;
import Utilities.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewFlightTests {

    private LoginPage loginPage;
    private HomePage homePage;
    private NewFlightPage newFlightPage;
    private AfterFlihgtPage afterFlihgtPage;

    @BeforeTest
    public void setup(){
        loginPage = new LoginPage(Browser.Chrome);
        loginPage.goTo("https://demo.guru99.com/test/newtours/index.php");
        loginPage.login("admin", "admin");

        homePage = new HomePage(loginPage.getDriver());
        homePage.goToFlightRegister();
    }

    @Test
    public void createFlight(){
        newFlightPage = new NewFlightPage(homePage.getDriver());
        newFlightPage.createNewFlight();

        afterFlihgtPage = new AfterFlihgtPage(newFlightPage.getDriver());
        Assert.assertTrue(afterFlihgtPage.isInPage());
    }

    @AfterMethod
    public void teardown(){
        homePage.quit();
        System.out.println("Tear down method");
    }
}
