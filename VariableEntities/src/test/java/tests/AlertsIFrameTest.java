package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.iFrameOnlinerPage;
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

    @Test //некорректны шаги воспроизведения в дз поэтому сделал так
    public void iFrameOnlinerTest(){

        iFrameOnlinerPage iFrameOnlinerPage = new iFrameOnlinerPage(browsersService, true);
        iFrameOnlinerPage.fastSearchInput().sendKeys("тостер");
        browsersService.getDriver().switchTo().frame(iFrameOnlinerPage.iFrameSearch());
        iFrameOnlinerPage.firstProductName();
        iFrameOnlinerPage.searchInFrame().clear();
        iFrameOnlinerPage.searchInFrame().sendKeys(iFrameOnlinerPage.firstProductName());
        iFrameOnlinerPage.selectFirstProduct().click();

        Assert.assertEquals(iFrameOnlinerPage.confirm(), "Тостер Philips HD2581/00");
    }

    @Test //как реализовать проверку, что страница пролисталась до самого низа?
    public void jsExecutorTest(){

        iFrameOnlinerPage iFrameOnlinerPage = new iFrameOnlinerPage(browsersService, true);
        JavascriptExecutor js = (JavascriptExecutor) browsersService.getDriver();
        js.executeScript("window.scrollBy(0,10000)");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
