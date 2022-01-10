package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile =driver.findElement(By.id("file-upload"));
        WebElement uploadFile =driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys("B:\\study\\Учеба TMS\\SharedScreenshot.jpg");
        uploadFile.click();

        Thread.sleep(5000);
    }

}
