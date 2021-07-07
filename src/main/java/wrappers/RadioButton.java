package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {

    private UIElement webElement;
    private List<UIElement> optionList = new ArrayList<>();
    private List<String> optionTextList = new ArrayList<>();
    private WebDriver webDriver;

    public RadioButton(WebDriver webDriver, By by){
        this.webDriver = webDriver;
        List<WebElement> option = webDriver.findElements(by);
        optionTextList = getAllOptions(option);

    }

    private List<String> getAllOptions(List<WebElement> radioList){
        List<String> resultNameList = new ArrayList<>();

        for(WebElement webElement : radioList){
            UIElement uiElement = new UIElement(webDriver, webElement);
            optionList.add(uiElement);
            resultNameList.add(uiElement.getParent().findElement(By.tagName("strong")).getText());
        }
        return resultNameList;
    }

    public void selectByOpiton(String optionName){
       int index =  optionTextList.indexOf(optionName);
       optionList.get(index).click();
    }

    public void selectByValue(String value){
        for(WebElement opt : optionList){
         if(opt.getAttribute("value").equals(value)){
             opt.click();
         }
        }

    }

    public void selectByNumber(int number){
        optionList.get(number).click();
    }
}
