package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private UIElement webElement;
    private List<DropDownElement> dropDownElementsList = new ArrayList<>();

    public DropDown (WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);

        for (WebElement webElement : webElement.findElements(By.xpath("//div[contains(@class, 'dropdown')]//a"))){
            dropDownElementsList.add(new DropDownElement(webDriver, webElement));
        }
    }

    private boolean isDropDownSelected(){
        try {
            if (webElement.findElement(By.cssSelector("div.dropdown[style*='none']")).isDisplayed()) {
                return true;
            }
        }catch (Exception ignored){
        }
        return false;
    }

    public void show(){
        if(!isDropDownSelected()){
          openDropDown();
        }

    }

    public void hide(){
        if(!isDropDownSelected()){
            openDropDown();
        }

    }

    public void selectElementInDropDown(String name){
        show();
        for(DropDownElement option : dropDownElementsList){
            if(option.getName().equals(name)){
                option.click();
                break;
            }
        }
    }

    private void openDropDown(){
        webElement.click();
    }

}
