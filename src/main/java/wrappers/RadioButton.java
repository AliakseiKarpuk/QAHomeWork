package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement webElement;
    private List<RadioButtonElements> radioButtonElementsList = new ArrayList<>();
    private List<RadioButtonElements> radioButtonNameList = new ArrayList<>();

    public RadioButton(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
        for(WebElement webElement : webElement.findElements(By.cssSelector("[name='suite_mode']"))){
            radioButtonElementsList.add(new RadioButtonElements(webDriver, webElement));
        }
        for (WebElement webElement : webElement.findElements(By.xpath("//*[@name='suite_mode']/parent::label/child::strong"))){
            radioButtonNameList.add(new RadioButtonElements(webDriver, webElement));
        }
    }

    public void selectByValue(int value){
        for (RadioButtonElements option : radioButtonElementsList){
            if(option.getValue().equals(Integer.toString(value))){
                option.click();
            }
        }
    }

    public void selectByNumber(int number){
            radioButtonElementsList.get(number).click();
    }

    public void selectByName(String name) {
        int index = 0;

        for (RadioButtonElements option : radioButtonNameList) {
            for (int i = 0; i < radioButtonNameList.size(); i++){
                if(radioButtonNameList.get(i).getName().equals(name)){
                    radioButtonElementsList.get(i).click();
                    break;
                }
            }
        }
    }
}
