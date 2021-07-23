package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertPage extends BasePage {

    private static String END_POINT = "javascript_alerts";
    private static final By jsAlertButtonBy = By.cssSelector("[onclick='jsAlert()']");
    private static final By jsConfirmButtonBy = By.cssSelector("[onclick='jsConfirm()']");
    private static final By jsPromtButtonBy = By.cssSelector("[onclick='jsPrompt()']");
    private static final By confirmBy = By.id("result");


    public AlertPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(baseUrl+END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return jsAlertButton().isDisplayed();
    }

    public WebElement jsAlertButton(){
        return driver.findElement(jsAlertButtonBy);
    }
public WebElement jsConfirmButton(){
        return driver.findElement(jsConfirmButtonBy);
    }
public WebElement jsPromtButton(){
        return driver.findElement(jsPromtButtonBy);
    }
    public String confirm(){
        return driver.findElement(confirmBy).getText();
    }
}
