package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTestCasesPage extends BasePage {

    @FindBy(id = "title")
    public WebElement title;
    @FindBy(id = "custom_preconds_display")
    public WebElement preconditions;
    @FindBy(id = "custom_steps_display")
    public WebElement steps;
    @FindBy(id = "custom_expected_attachments_wrapper")
    public WebElement expectedResult;
    @FindBy(id = "accept")
    public WebElement addTestCaseButton;
    @FindBy(xpath= "//*[@class='button button-negative button-delete']/parent::a[@href]")
    public WebElement deleteTestCaseButton;

    public AddTestCasesPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
public AddTestCasesPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaits().waitForVisibility(expectedResult).isDisplayed();

    }

}
