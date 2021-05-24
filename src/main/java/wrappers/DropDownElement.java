package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownElement {
    private UIElement webElement;


    public DropDownElement(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }

    public DropDownElement(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }

    public String getName(){
       return webElement.getText();
    }
    public void click(){
        webElement.click();
    }
}
