package pages.dialogs;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirm extends BasePage {

    @FindBy(css = "span[class='dialog-confirm-busy']+input[name='deleteCheckbox']")
    public WebElement confirmDelete;
     @FindBy(xpath = "//*[@id='deleteDialog']/div/a[@class='button button-ok button-left button-positive dialog-action-default']")
    public WebElement okButton;
     @FindBy(xpath = "//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all dialog ui-draggable']")
    public WebElement dialogWindow;
     @FindBy( css= "button button-left button-positive button-no-margin-right dialog-action-secondary button-black")
    public WebElement deletePermanentlyButton;
     @FindBy(xpath = "//*[@class='button button-left button-ok button-positive dialog-action-default']")
    public WebElement markAsDelete;

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
        return browsersService.getWaits().waitForVisibility(dialogWindow).isDisplayed();
    }

}
