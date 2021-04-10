package pages.dialogs;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteConfirm extends BasePage {

    protected static final By confirmDeleteBy = By.cssSelector("span[class='dialog-confirm-busy']+input[name='deleteCheckbox']");
    protected static final By okButtonBy  = By.xpath("//*[@id='deleteDialog']/div/a[@class='button button-ok button-left button-positive dialog-action-default']");
    protected static final By dialogWindowBy = By.id("dialog-ident-deleteDialog");

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
        return dialogWindow().isEnabled();
    }

    public WebElement confirmDelete(){ return driver.findElement(confirmDeleteBy);}
    public WebElement okButton(){ return driver.findElement(okButtonBy);}
    public WebElement dialogWindow(){ return driver.findElement(dialogWindowBy);}
}
