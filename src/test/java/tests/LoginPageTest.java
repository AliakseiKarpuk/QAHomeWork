package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginPageTest extends BaseTest {

    @Test
    public void LoginWithPswAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    public void LoginWithoutPasswordAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","");

        Assert.assertTrue(loginPage.getEmailRequired().isDisplayed());
        Assert.assertTrue(loginPage.getPswRequired().isDisplayed());

    }

    @Test
    public void LoginWithoutEmail(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","QqtRK9elseEfAk6ilYcJ");

        Assert.assertTrue(loginPage.getEmailRequired().isDisplayed());
    }

    @Test
    public void LoginWithoutPsw(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("atrostyanko+0401@gmail.com","");

        Assert.assertTrue(loginPage.getPswRequired().isDisplayed());
    }
}
