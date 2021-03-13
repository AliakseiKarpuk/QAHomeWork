import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class Task2 {
    @Test
    public void smokeTest1(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        roomLength.sendKeys(Keys.chord(Keys.CONTROL, "a"), "8" );

        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        roomWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "5" );

        WebElement laminateLength = driver.findElement(By.name("calc_lamwidth"));
        laminateLength.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1100" );

        WebElement laminateWidth = driver.findElement(By.name("calc_lamheight"));
        laminateWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "200" );

        WebElement numberInPack = driver.findElement(By.name("calc_inpack"));
        numberInPack.sendKeys(Keys.chord(Keys.CONTROL, "a"), "15" );

        WebElement price = driver.findElement(By.name("calc_price"));
        price.sendKeys(Keys.chord(Keys.CONTROL, "a"), "750" );

        WebElement selectWebElement = driver.findElement(By.className("bigheight"));
        Select stylingMethod = new Select(selectWebElement);
        stylingMethod.selectByValue("toh");

        WebElement row = driver.findElement(By.name("calc_bias"));
        row.sendKeys(Keys.chord(Keys.CONTROL, "a"), "350");

        WebElement indent = driver.findElement(By.name("calc_walldist"));
        indent.sendKeys(Keys.chord(Keys.CONTROL, "a"), "15");

        WebElement calcBtn = driver.findElement(By.className("btn-lg"));
        calcBtn.click();

        WebElement result1 = driver.findElement(By.xpath("//b[text()='39.61']"));
        Assert.assertEquals(result1.getText(), "39.61", "Площадь укладки");

        WebElement result2 = driver.findElement(By.xpath("//b[text()='187']"));
        Assert.assertEquals(result2.getText(), "187", "Кол-во панелей");

        WebElement result3 = driver.findElement(By.xpath("//b[text()='13']"));
        Assert.assertEquals(result3.getText(), "13", "Кол-во упаковок");

        WebElement result4 = driver.findElement(By.xpath("//b[text()='32175']"));
        Assert.assertEquals(result4.getText(), "32175", "Стоимость");

        WebElement result5 = driver.findElement(By.xpath("//b[text()='8']"));
        Assert.assertEquals(result5.getText(), "8", "Остатки");

        WebElement result6 = driver.findElement(By.xpath("//b[text()='14']"));
        Assert.assertEquals(result6.getText(), "14", "Отрезки");

        driver.quit();
    }
}
