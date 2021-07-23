package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamiControlPage extends BasePage {

    private static String END_POINT = "dynamic_controls";
    private static By checkboxBy = By.cssSelector("#checkbox>input");
    private static By removeButtonBy = By.cssSelector("#checkbox + button");
    private static By messageRemove = By.id("message");
    private static By inputBy = By.cssSelector("#input-example > input");
    private static By enableButtonBy = By.cssSelector("#input-example>button");


    public DynamiControlPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(baseUrl+END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return getCheckbox().isDisplayed();
    }

    public WebElement getCheckbox(){
        return browsersService.getWaits().waitForVisibility(checkboxBy);
    }

    public WebElement getRemoveButton(){
        return browsersService.getWaits().waitForVisibility(removeButtonBy);
    }

    public String getMessage(){
        return browsersService.getWaits().waitForVisibility(messageRemove).getText();
    }

    public WebElement getInput(){
        return browsersService.getWaits().waitForVisibility(inputBy);
    }

    public WebElement getEnableButton(){
        return browsersService.getWaits().waitForVisibility(enableButtonBy);
    }
}
