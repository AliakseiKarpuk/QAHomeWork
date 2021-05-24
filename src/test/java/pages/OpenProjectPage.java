package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OpenProjectPage extends BasePage {

    @FindBy(id = "sidebar-cases-add")
    public WebElement addTestCasesButton;
    @FindBy(id = "navigation-suites")
    public WebElement getAllTestCases;
    @FindBy(css = "tbody>tr.caseRow")
    public WebElement allTestCases;
    @FindBy(xpath = "//*[@id='row-7']/td/input")
    public WebElement openTestCaseButton;
    @FindBy(id = "editCases")
    public WebElement editCases;
    @FindBy(xpath = "//*[@class='button-text']/parent::a[@href]")
    public WebElement editButton;
    @FindBy(id = "deleteCases")
    public WebElement deleteButton;
    @FindBy(css = ".message.message-success")
    public WebElement successText;

    protected static final String getTestCaseBy = "//span[text()='remove']";

    public OpenProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
public OpenProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaits().waitForVisibility(deleteButton).isDisplayed();
    }

    public WebElement getTestCase(String testCaseName){
        return browsersService.getWaits().waitForVisibility(By.xpath(getTestCaseBy.replace("remove", testCaseName)));
    }
}
