package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow {
    private UIElement webElement;
    private List<RowsCell> cellsList = new ArrayList<>();
    private WebDriver webDriver;
    private int cellsCount;

    public TableRow(WebDriver webDriver, By by) {
        this.webDriver = webDriver;
        this.webElement = new UIElement(webDriver, by);

    }

    public TableRow(WebDriver webDriver, WebElement webElement) {
        this.webElement = new UIElement(webDriver, webElement);
        this.webDriver = webDriver;

    }

    private void createCellsList(){

        for (WebElement webElement : webElement.findElements(By.tagName("td"))){
            cellsList.add(new RowsCell(webDriver, webElement));
        }
    }

    public int getCellsCount(){
        return this.cellsCount;
    }

    public void setCellsCount(int cellsCount) {
        this.cellsCount = cellsCount;
    }
}
