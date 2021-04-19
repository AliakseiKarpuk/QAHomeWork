package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    private UIElement webElement;
    private WebDriver webDriver;

    public Checkbox(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }
    public Checkbox(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }

    private boolean isCheckboxSelected(){
        return webElement.isSelected();
    }

    public void turnOn(){
        if(!isCheckboxSelected()){
            webElement.click();
        }
    }
    public void turnOff() {
        if (isCheckboxSelected()) {
            webElement.click();
        }
    }
}
