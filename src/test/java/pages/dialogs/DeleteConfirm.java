package pages.dialogs;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteConfirm extends BasePage {

    protected static final By confirmDeleteBy = By.cssSelector("span[class='dialog-confirm-busy']+input[name='deleteCheckbox']");
    protected static final By okButtonBy  = By.xpath("//*[@id='deleteDialog']/div/a[@class='button button-ok button-left button-positive dialog-action-default']");
    protected static final By dialogWindowBy = By.xpath("//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all dialog ui-draggable']");
    protected static final By deletePermanentlyButtonBy = By.xpath("button button-left button-positive button-no-margin-right dialog-action-secondary button-black");
    protected static final By marlAsDeleteBy = By.xpath("//*[@class='button button-left button-ok button-positive dialog-action-default']");

    public DeleteConfirm(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public DeleteConfirm(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return dialogWindow().isDisplayed();
    }

    public WebElement confirmDelete(){ return driver.findElement(confirmDeleteBy);}
    public WebElement okButton(){
        return browsersService.getWaits().waitForVisibility(okButtonBy);
    }
    public WebElement dialogWindow(){ return driver.findElement(dialogWindowBy);}
    public WebElement deletePermanentlyButton(){ return driver.findElement(deletePermanentlyButtonBy); }
    public WebElement markAsDeleteButton(){
        return browsersService.getWaits().waitForVisibility(marlAsDeleteBy);
    }
}
