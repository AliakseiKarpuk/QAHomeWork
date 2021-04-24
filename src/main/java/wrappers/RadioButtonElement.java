package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonElement {

    private UIElement webElement;


    public RadioButtonElement(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }

    public RadioButtonElement(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }

    public String getValue(){
       return webElement.getAttribute("value");
    }


    public String getName(){
       return webElement.getText();
    }

    public void click(){
        webElement.click();
    }

}
