package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        //loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        //loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        //loginPage.getLoginButton().click();

      }
    @Test
    public void openProjectTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openProject();}

    @Test
    public void addProjectTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.addProject();
        addProjectPage.createProject(ReadProperties.getNewProjectName(),ReadProperties.getAnnouncement());

    }
   }

