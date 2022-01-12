package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Описание элементов страницы
    private static String ENDPOINT = "/auth/login";

    private By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");

    private By email_Selector = By.id("name");
    private By password_Selector = By.id("password");
    private By login_Selector = By.id("button_primary");

    // Конструктор страницы
    public LoginPage(WebDriver driver) {
    super(driver);
}

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened(){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
}

    // Реализация гетерров элементов
    public WebElement getEmailField(){
    return driver.findElement(email_Selector);
}

    public WebElement getPasswordField(){
        return driver.findElement(password_Selector);
    }

    public WebElement getLoginButton(){
        return driver.findElement(login_Selector);
    }

    // Реализация базовых методов

    public void login(String username, String password){
        getEmailField().sendKeys(ReadProperties.getUsername());
        getPasswordField().sendKeys(ReadProperties.getPassword());
        getLoginButton().click();
    }
}
