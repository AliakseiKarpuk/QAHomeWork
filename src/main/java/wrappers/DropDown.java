package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown {

    private UIElement webElement;
    private WebDriver webDriver;

    public DropDown (WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
    }
    public DropDown (WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
    }

    private void isDropDownSelected(){

    }

    public void show(){

    }

    public void hide(){

    }

    public void selectElementInDropDown(String name){

    }

}
