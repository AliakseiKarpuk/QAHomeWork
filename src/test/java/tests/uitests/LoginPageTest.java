package tests.uitests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginPageTest extends BaseTest {

    @Test(description = "Логин с паролем и емаил")
    public void LoginWithPswAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(description = "Логин без пароля и емаила")
    public void LoginWithoutPasswordAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","");

        Assert.assertTrue(loginPage.emailRequired.isDisplayed());
        Assert.assertTrue(loginPage.pswRequired.isDisplayed());

    }

    @Test(description = "Логин без емаила")
    public void LoginWithoutEmail(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","QqtRK9elseEfAk6ilYcJ");

        Assert.assertTrue(loginPage.emailRequired.isDisplayed());
    }

    @Test(description = "Логин без пароля")
    public void LoginWithoutPsw(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("atrostyanko+0401@gmail.com","");

        Assert.assertTrue(loginPage.pswRequired.isDisplayed());
    }
}
