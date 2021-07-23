package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.iFramePage;

public class AlertsIFrameTest extends BaseTest {

    @Test
    public void AlertsTest(){

        AlertPage alertPage = new AlertPage(browsersService, true);
        alertPage.jsAlertButton().click();
        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();
        Assert.assertEquals(alertPage.confirm(), "You successfully clicked an alert");

        alertPage.jsConfirmButton().click();
        alert.dismiss();
        Assert.assertEquals(alertPage.confirm(), "You clicked: Cancel");

        alertPage.jsPromtButton().click();
        alert.sendKeys("12345");
        alert.accept();
        Assert.assertEquals(alertPage.confirm(), "You entered: 12345");
    }

    @Test
    public void iFrameTest(){

        iFramePage iFramePage = new iFramePage(browsersService, true);
        browsersService.getDriver().switchTo().frame(iFramePage.iFrameID());
        iFramePage.inputText().clear();
        iFramePage.inputText().sendKeys("some text in iframe");
        browsersService.getDriver().switchTo().parentFrame();
        iFramePage.alignCenterButton().click();
        Assert.assertEquals(iFramePage.alignCenterButton().getAttribute("aria-pressed"), "true");
    }
}
