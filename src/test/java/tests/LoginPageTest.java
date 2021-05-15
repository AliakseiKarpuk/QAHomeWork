package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

@Epic("Main Epic")
@Feature("Login")
@Severity(SeverityLevel.BLOCKER)
public class LoginPageTest extends BaseTest {

    @Test(description = "Логин с коректными данными")
    @Description("Логин с корректными паролем и емаил")
    @Story("Логин с корректными данными")
    @TmsLink("65")
    @Link(name = "Test Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("AQA-7103")
    public void LoginWithPswAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(description = "Логин с некоректными данными")
    @Description("Логин без пароля и емаила")
    @Story("Логин с некорректными данными")
    @TmsLink("65")
    @Link(name = "Test Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("AQA-7104")
    public void LoginWithoutPasswordAndMail(){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","");

        Assert.assertTrue(loginPage.getEmailRequired().isDisplayed());
        Assert.assertTrue(loginPage.getPswRequired().isDisplayed());

    }

    @Test(description = "Логин с некоректными данными")
    @Description("Логин с паролем и без емаила")
    @Story("Логин с некорректными данными")
    @TmsLink("65")
    @Link(name = "Test Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("AQA-7105")
    public void LoginWithoutEmail(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("","QqtRK9elseEfAk6ilYcJ");

        Assert.assertTrue(loginPage.getEmailRequired().isDisplayed());
    }

    @Test(description = "Логин с некоректными данными")
    @Description("Логин с емаилом и без пароля")
    @Story("Логин с некорректными данными")
    @TmsLink("65")
    @Link(name = "Test Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Issue("AQA-7106")
    public void LoginWithoutPsw(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("atrostyanko+0401@gmail.com","");

        Assert.assertTrue(loginPage.getPswRequired().isDisplayed());
    }
}
