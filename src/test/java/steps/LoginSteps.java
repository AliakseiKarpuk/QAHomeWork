package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    private LoginPage loginPage;
    private AddProjectPage addProjectPage;
    private ProjectSteps projectSteps;

    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
        loginPage = new LoginPage(browsersService, true);

    }

    @Step("Логин с корректными '{email}' '{psw}'")
    public DashboardPage loginWithCorrectCredentials(String email, String psw) {

       setEmail(email);
       setPsw(psw);
       clickButton();

        return new DashboardPage(browsersService, false);
    }

    @Step("Логин с некорректными '{email}' '{psw}'")
    public LoginPage loginWithIncorrectCredentials(String email, String psw) {

        setEmail(email);
        setPsw(psw);
        clickButton();

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

    private LoginSteps clickButton(){

        loginPage.logInButton.click();

        return this;
    }

    public LoginPage getCurrentLoginPage(){

        return loginPage;
    }
    public ProjectSteps loginWithCorrectCredential(String email, String psw) {

        setEmail(email);
        setPsw(psw);
        clickButton();

        AddProjectPage addProjectPage = new AddProjectPage(browsersService, true);

        return projectSteps;
    }


}
