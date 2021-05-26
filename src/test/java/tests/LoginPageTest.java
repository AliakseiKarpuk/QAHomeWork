package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

@Epic("Main Epic")
@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class LoginPageTest extends BaseTest {

    public Logger logger = LogManager.getLogger();

    @Test(description = "Login with correct credentials")
    @Description("Login with correct email and password")
    @Story("Login with correct credentials")
    public void LoginWithPswAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(description = "Login with incorrect credentials")
    @Description("Login without email and password")
    @Story("Login with incorrect credentials")
    public void LoginWithoutPasswordAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","");

        Assert.assertTrue(loginPage.emailRequired.isDisplayed());
        Assert.assertTrue(loginPage.pswRequired.isDisplayed());

    }

    @Test(description = "Login with incorrect credentials")
    @Description("Login with password and without email")
    @Story("Login with incorrect credentials")
    public void LoginWithoutEmail(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","QqtRK9elseEfAk6ilYcJ");

        Assert.assertTrue(loginPage.emailRequired.isDisplayed());
    }

    @Test(description = "Login with incorrect credentials")
    @Description("Login with email and without password")
    @Story("Login with incorrect credentials")
    public void LoginWithoutPsw(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("atrostyanko+0401@gmail.com","");

        Assert.assertTrue(loginPage.pswRequired.isDisplayed());
    }
}
