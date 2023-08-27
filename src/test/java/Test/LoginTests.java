package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Browser;
import Utilities.General;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class LoginTests {

    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser){
        loginPage = new LoginPage(General.getBrowserFromString(browser));
        loginPage.goTo("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderEx.class)
    public void login(String username, String password){

        loginPage.login(username, password);

        homePage = new HomePage(loginPage.getDriver());
        Assert.assertTrue(homePage.isInHomePage());
    }

    @AfterMethod
    public void teardown(ITestResult result){
        String name;

        if(result.isSuccess()) name = "Pass-";
        else name = "Fail-";

        name +=  result.getName();

        General.takeScreenShot(homePage.getDriver(), "src/test/screenshots/", name);
        homePage.quit();
    }
}
