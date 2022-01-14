package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(0);
        //Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Your content goes here.");
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        //driver.switchTo().parentFrame(); // На один уровень выше
        driver.switchTo().defaultContent(); // Возврат на главную страницу
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());
    }
}
