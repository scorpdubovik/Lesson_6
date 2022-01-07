package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InputsPage extends BasePage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By PAGE_OPENED_IDENTIFIER2 = By.tagName("h3");
    String expectedPageOpenIdentifier = "Inputs";

    private By inputs_Selector = By.cssSelector("a[href='/inputs']");
    private By number_Field = By.cssSelector("[type='number']");

    //Конструктор страницы
    public InputsPage(WebDriver driver) {super(driver);}

    public boolean isPageOpen(){return super.isPageOpen(PAGE_OPENED_IDENTIFIER); }

    // Реализация гетерров элементов
    public WebElement getInputPage() {return driver.findElement(inputs_Selector);}
    public WebElement getInputField() {return driver.findElement(number_Field);}
    public WebElement getPageOpenIdentifier(){
        return driver.findElement(PAGE_OPENED_IDENTIFIER2);
    }

    // Реализация базовых методов
    public void openInputsPage(){
        getInputPage().click();
        Assert.assertEquals(getPageOpenIdentifier().getText(), expectedPageOpenIdentifier,"Inputs page didn't open");
    }
    public void inputNumbers() { getInputField().sendKeys(ReadProperties.getNumber());



}
}
