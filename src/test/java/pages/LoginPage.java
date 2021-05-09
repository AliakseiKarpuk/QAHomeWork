package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    @FindBy(id = "name")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "button_primary")
    public Button logInButton;
    @FindBy(className = "error-text")
    public WebElement errorLabel;
    @FindBy(xpath = "//div[text()='Email/Login is required.']")
    public WebElement emailRequired;
    @FindBy(xpath = "//div[text()='Password is required.']")
    public WebElement pswRequired;

    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return browsersService.getWaits().waitForVisibility(passwordInput).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

}
