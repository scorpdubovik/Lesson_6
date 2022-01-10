package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebElement chooseFile =driver.findElement(By.id("file-upload"));
        WebElement uploadFile =driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys("B:\\study\\Учеба TMS\\SharedScreenshot.jpg");
        uploadFile.click();

        Waits waits = new Waits(driver);
        WebElement header = waits.waitForVisibility(By.xpath("//h3[. = 'File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));

        //WebElement header = driver.findElement(By.xpath("//h3[. = 'File Uploaded!']"));
        //WebElement fileName = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed()); // Показывает что элемент есть на странице и отображается
        //Assert.assertTrue(header != null); // Показывает что элемент есть на страницы, но не обязательно отображается
        Assert.assertEquals(fileName.getText(), "SharedScreenshot.jpg" );
        Thread.sleep(5000);
    }

}
