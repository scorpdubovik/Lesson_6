package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork {
    static String URL = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";

    @Test
    public void homework_test1(){
        String floorWidthValue = "6";
        String floorLengthValue = "9";
        String heatLossValue = "63";

        String expectedPower = "35";
        String expectedSpecificPower = "1";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // 1.Открыть браузер и перейти на тестируемую страницу

        driver.get(URL);

        // 2.Ввести ширину пола
        WebElement floorWidth = driver.findElement(By.id("el_f_width"));
        floorWidth.sendKeys(floorWidthValue);

        // 3.Ввести длину пола
        WebElement floorLength = driver.findElement(By.id("el_f_lenght"));
        floorLength.sendKeys(floorLengthValue);

        // 4.Выбрать помещение
        WebElement room = driver.findElement(By.id("room_type"));
        Select roomDropDown = new Select(room);
        roomDropDown.selectByVisibleText("Ванная");

        // 5.Выбрать тип обогрева
        WebElement heatingType = driver.findElement(By.id("heating_type"));
        Select heatingTypeDropDown = new Select(heatingType);
        heatingTypeDropDown.selectByValue("3");

        // 6.Ввести теплопотери
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        heatLoss.sendKeys(heatLossValue);

        // 7.Нажать на кнопку 'Рассчитать'
        WebElement calculate = driver.findElement(By.cssSelector("input[type='button']"));
        calculate.click();

        // 8.Проверить результаты
        String actualPower = driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actualSpecificPower = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");

        Assert.assertEquals(actualPower, expectedPower, "Мощность нагревательного кабеля разная");
        Assert.assertEquals(actualSpecificPower, expectedSpecificPower, "Удельная мощность нагревательного кабеля разная");

        driver.quit();
    }
}
