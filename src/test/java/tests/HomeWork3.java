package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork3 {
    static String URL = "https://calc.by/building-calculators/laminate.html";

    @Test
    public void homework_test3() throws InterruptedException {
        String roomLengthValue = "500";
        String roomWidthValue = "400";
        String lamLengthValue = "2000";
        String lamWidthValue = "200";
        //String lamInPackValue = "";
        //String minimumTrimmingLength = "";
        //String walldistValue = "";

        String expectedRequiredNumberOfLam = "53";
        String expectedNumberOfLamPack = "7";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // 1.Открыть браузер и перейти на тестируемую страницу
        driver.get(URL);

        // 2.Ввести длину комнаты
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.sendKeys(roomLengthValue);

        // 3.Ввести ширину комнаты
         WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
         roomWidth.sendKeys(roomWidthValue);

        // 4.Ввести длину панели ламината
        WebElement lamLength = driver.findElement(By.id("ln_lam_id"));
        lamLength.sendKeys(lamLengthValue);

        // 5.Ввести ширину панели ламината
        WebElement lamWidth = driver.findElement(By.id("wd_lam_id"));
        lamWidth.sendKeys(lamWidthValue);

        // 6.Выбрать направление укладки
        WebElement layingDirection = driver.findElement(By.cssSelector("div[style='padding:5px 0;'] :nth-child(9)"));
        Select layingDirectionRadioButton = new Select(layingDirection);
        layingDirectionRadioButton.selectByVisibleText("по ширине комнаты");



       // driver.quit();

        //div:nth-child(9) > div.cl-ln-value.cl-left.cl50
        //div[style='padding:5px 0;'] :nth-child(9)
    }
}
