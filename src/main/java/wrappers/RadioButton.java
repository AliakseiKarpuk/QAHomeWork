package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement webElement;
    private List<RadioButtonElement> radioButtonElementsList = new ArrayList<>();
    private List<RadioButtonElement> radioButtonNameList = new ArrayList<>();

    public RadioButton(WebDriver webDriver, By by) {
        this.webElement = new UIElement(webDriver, by);
        for(WebElement webElement : webElement.findElements(By.cssSelector("div.radio>label>strong+input"))){
            radioButtonElementsList.add(new RadioButtonElement(webDriver, webElement));
        }
        for (WebElement webElement : webElement.findElements(By.xpath("//div[@class='radio']/label/strong"))){
            radioButtonNameList.add(new RadioButtonElement(webDriver, webElement));
        }
    }

    public void selectByValue(int value){
        for (RadioButtonElement option : radioButtonElementsList){
            if(option.getValue().equals(Integer.toString(value))){
                option.click();
            }
        }
    }

    public void selectByNumber(int number){
            radioButtonElementsList.get(number).click();
    }

    public void selectByName(String name) {

        for (RadioButtonElement option : radioButtonNameList) {
            for (int i = 0; i < radioButtonNameList.size(); i++){
                if(radioButtonNameList.get(i).getName().equals(name)){
                    radioButtonElementsList.get(i).click();
                    break;
                }
            }
        }
    }
}
