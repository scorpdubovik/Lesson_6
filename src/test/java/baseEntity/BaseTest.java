package baseEntity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import steps.TestCaseSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected User user;
    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;
    protected TestCaseSteps testCaseSteps;

    @BeforeClass
    public void setUp() {
        //for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.getBrowserName().toLowerCase();
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        Configuration.headless = ReadProperties.isHeadless();

        projectSteps = new ProjectSteps();
        milestoneSteps = new MilestoneSteps();
        testCaseSteps = new TestCaseSteps();

        // Login
        open("/");
        LoginPage loginPage = new LoginPage();

        loginPage.getUsernameField().val(ReadProperties.getUsername());
        loginPage.getPasswordField().setValue(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
    }

    @AfterClass
    public void closePage() {
        closeWebDriver();
    }
}