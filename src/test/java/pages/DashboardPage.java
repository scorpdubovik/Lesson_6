package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {

    private static String ENDPOINT = "/index.php?/dashboard";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    protected By administrationButtonSelector = By.id("navigation-admin");

    public SelenideElement getAddProjectButton() {
        return $(addProjectButtonSelector);
    }

    public SelenideElement getAdministrationButton() {
        return $(administrationButtonSelector);
    }

    public void openPage() {
        open(ENDPOINT);
    }

}
