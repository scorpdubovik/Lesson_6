package HomeWork;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void waitsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[. = 'Start']"));
        button.click();

        WebElement loading = driver.findElement(By.cssSelector("div[id='loading']"));
        Assert.assertTrue(loading.isDisplayed());


        Waits waits = new Waits(driver);
        Assert.assertTrue(waits.waitForInvisibility(loading,10));

        //WebElement loading = waits.waitForVisibility(By.cssSelector("div[id='loading']"));
        //Assert.assertTrue(loading.isDisplayed());

        WebElement helloWord = waits.waitForVisibility(By.xpath("//h4[. = 'Hello World!']"));
        Assert.assertEquals(helloWord.getText(), "Hello World!");
    }

}
