package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DisappearingPage extends BasePage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By PAGE_OPENED_IDENTIFIER2 = By.tagName("h3");
    String expectedPageOpenIdentifier = "Disappearing Elements";

    private By disappearing_Selector = By.cssSelector("a[href='/disappearing_elements']");
    //private By number_Field = By.cssSelector("[type='number']");

    //Конструктор страницы
    public DisappearingPage(WebDriver driver) {super(driver);}

    public boolean isPageOpen(){return super.isPageOpen(PAGE_OPENED_IDENTIFIER); }

    // Реализация гетерров элементов
    public WebElement getDisappearingPage() {return driver.findElement(disappearing_Selector);}
   // public WebElement getInputField() {return driver.findElement(number_Field);}
    public WebElement getPageOpenIdentifier(){
        return driver.findElement(PAGE_OPENED_IDENTIFIER2);
    }

    // Реализация базовых методов
    public void openDisappearingPage(){
        getDisappearingPage().click();
        Assert.assertEquals(getPageOpenIdentifier().getText(), expectedPageOpenIdentifier,"Inputs page didn't open");
    }
    public void disappearingElement() {

}
}
