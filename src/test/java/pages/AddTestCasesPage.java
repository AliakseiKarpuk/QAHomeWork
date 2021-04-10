package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddTestCasesPage extends BasePage {

    protected static final By titleBy = By.id("title");
    protected static final By typeBy = By.id("type_id_chzn_o_4");
    protected static final By priorityBy = By.id("priority_id_chzn_o_3");
    protected static final By preconditionsBy = By.cssSelector("#custom_preconds.form-control");
    protected static final By stepsBy = By.cssSelector("#custom_steps.form-control");
    protected static final By expectedResult = By.cssSelector("#custom_expected.form-control");
    protected static final By addTestCaseButtonBy = By.id("accept");

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
        return getTitleInput().isDisplayed();
    }

    public WebElement getTitleInput(){ return driver.findElement(titleBy);}
    public WebElement getType(){ return driver.findElement(typeBy);}
    public WebElement getPriority(){ return driver.findElement(priorityBy);}
    public WebElement getPreconditions(){ return driver.findElement(preconditionsBy);}
    public WebElement getSteps(){ return driver.findElement(stepsBy);}
    public WebElement getExpectedResult(){ return driver.findElement(expectedResult);}
    public WebElement getAddTestCaseButton(){ return driver.findElement(addTestCaseButtonBy);}
}
