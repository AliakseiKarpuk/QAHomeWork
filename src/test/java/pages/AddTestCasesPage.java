package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTestCasesPage extends BasePage {

    @FindBy(id = "title")
    public WebElement title;
    @FindBy(css = "#custom_preconds.form-control")
    public WebElement preconditions;
    @FindBy(css = "#custom_steps.form-control")
    public WebElement steps;
    @FindBy(css = "#custom_expected.form-control")
    public WebElement expectedResult;
    @FindBy(id = "accept")
    public WebElement addTestCaseButton;
    @FindBy(xpath = "//*[@class='button button-negative button-delete']/parent::a[@href]")
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
        return browsersService.getWaits().waitForVisibility(addTestCaseButton).isDisplayed();

    }
}
