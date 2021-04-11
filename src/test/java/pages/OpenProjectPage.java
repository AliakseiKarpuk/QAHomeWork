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
    protected static final By openTestCaseButtonBy = By.xpath("//*[@id=\"row-7\"]/td/input");
    protected static final By editCases = By.id("editCases");
    protected static final By editButtonBy = By.xpath("//*[@class='button-text']/parent::a[@href]");
    protected static final By deleteButtonBy = By.id("deleteCases");
    protected static final By successTextBy = By.cssSelector(".message.message-success");

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
        return browsersService.getWaits().waitForVisibility(getAllTestCasesBy).isDisplayed();
    }

    public WebElement getAddTestCasesButton(){ return driver.findElement(addTestCasesButtonBy);}
    public WebElement getAllTestCasesButton(){
        return browsersService.getWaits().waitForVisibility(getAllTestCasesBy);
    }
    public WebElement getTestCase(String testCaseName){
        return browsersService.getWaits().waitForVisibility(By.xpath(getTestCaseBy.replace("remove", testCaseName)));
    }
    public WebElement getOpenTestCaseButton(){
        return browsersService.getWaits().waitForVisibility(openTestCaseButtonBy);
    }
    public WebElement getEditButton(){
        return browsersService.getWaits().waitForVisibility(editButtonBy);
    }
    public WebElement getEditCases(){ return driver.findElement(editCases);}
    public WebElement getDeleteButton(){ return driver.findElement(deleteButtonBy);}
    public WebElement getSuccessText(){
        return browsersService.getWaits().waitForVisibility(successTextBy);
    }

}
