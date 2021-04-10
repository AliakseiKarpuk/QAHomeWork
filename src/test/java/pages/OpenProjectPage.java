package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OpenProjectPage extends BasePage {

    protected static final By addTestCasesButtonBy = By.id("sidebar-cases-add");
    protected static final By getAllTestCasesBy = By.id("navigation-suites");
    protected static final String getTestCaseBy = "//span[text()='remove']";
    protected static final By allTestCases = By.cssSelector("tbody>tr.caseRow");
    protected static final String openTestCaseButtonBy = "//span[text()='remove']";
    protected static final By editButtonBy = By.cssSelector(".toolbar-button.toolbar-button-last.content-header-button.button-responsive.button-edit.toolbar-button-first");

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
        return getAddTestCasesButton().isDisplayed();
    }

    public WebElement getAddTestCasesButton(){ return driver.findElement(addTestCasesButtonBy);}
    public WebElement getAllTestCasesButton(){ return driver.findElement(getAllTestCasesBy);}
    public WebElement getTestCase(String testCaseName){ return driver.findElement(By.xpath(getTestCaseBy.replace("remove", testCaseName)));}
    public WebElement getOpenTestCaseButton(String testCaseName){ return driver.findElement(By.xpath(openTestCaseButtonBy.replace("remove", testCaseName)));}
    public Actions getEditButton(){
        Actions actions = new Actions(browsersService.getDriver());
        return actions.moveToElement(getEditButon(),5,5).click();
    }
    public WebElement getEditButon(){ return driver.findElement(editButtonBy);}

}
