package tests.uitests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectPage;
import steps.LoginSteps;
import steps.ProjectSteps;

import javax.swing.*;

public class SmokeTest1 extends BaseTest {

    @Test(groups = "smoke", timeOut = 5000l, description = "Логин с некоректными данными")
    public void LoginTest() {

        LoginSteps loginSteps = new LoginSteps(browsersService);

        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(groups = "regression")
    public void LoginTestWithIncorrectCredentials() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps
                .loginWithIncorrectCredentials("fwdfw", "fwwfw");

        Assert.assertEquals(loginPage.errorLabel.getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

}