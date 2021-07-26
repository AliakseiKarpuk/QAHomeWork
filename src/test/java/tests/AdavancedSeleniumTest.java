package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamiControlPage;
import steps.ContextMenuStep;


public class AdavancedSeleniumTest extends BaseTest {

    @Test
    public void ContextMenuTest(){

        ContextMenuStep contextMenuStep = new ContextMenuStep(browsersService);
        contextMenuStep.contextMenuStep();

        Alert alert = browsersService.getDriver().switchTo().alert();
        System.out.println(alert.getText());

        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void DynamicControlTest(){
        DynamiControlPage dynamiControlPage = new DynamiControlPage(browsersService, true);
        Actions actions = new Actions(browsersService.getDriver());
        actions
                .click(dynamiControlPage.getCheckbox())
                .click(dynamiControlPage.getRemoveButton()).build().perform();
        Assert.assertEquals(dynamiControlPage.getMessage() , "It's gone!");
        Assert.assertTrue(browsersService.getWaits().waitForInvisibility(By.id("checkbox")));

        Assert.assertEquals(dynamiControlPage.getInput().isEnabled(), false);
        actions.click(dynamiControlPage.getEnableButton()).build().perform();
        Assert.assertEquals(dynamiControlPage.getMessage(), "It's enabled!");
        Assert.assertEquals(dynamiControlPage.getInput().isEnabled(), true);
    }

}
