package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    private LoginPage loginPage;

    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
        loginPage = new LoginPage(browsersService, false);
    }

    public DashboardPage loginWithCorrectCredentials(String email, String psw){

        setEmail(email);
        setPsw(psw);
        clickBtn();

        return new DashboardPage(browsersService, false);
    }

    public LoginPage loginWithIncorrectCredentials(String email, String psw){

        setEmail(email);
        setPsw(psw);
        clickBtn();

        return loginPage;

    }

    private LoginSteps setEmail(String email){
        loginPage.emailInput.sendKeys(email);
        return this;
    }

    private LoginSteps setPsw(String psw){
        loginPage.passwordInput.sendKeys(psw);
        return this;
    }

    private  LoginSteps clickBtn(){
        loginPage.logInButton.click();
        return this;
    }

}
