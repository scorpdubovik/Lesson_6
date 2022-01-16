package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HwSmokeTest extends BaseTest {
    Project project = new Project();


    @Test()
    public void loginTest() {
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test(dependsOnMethods = "loginTest", alwaysRun = true)
    public void addNewProjectTest(){
//        Project project = new Project();

        AddProjectPage addProjectPage = new AddProjectPage(driver,true);
        addProjectPage.addNewProject(project);

        String projectNames = driver.findElement(By.cssSelector(".grid")).getText();
        Assert.assertTrue(projectNames.contains(project.getProjectName()));
        }

    @Test(dependsOnMethods = "loginTest", alwaysRun = true, priority = 1)
    public void updateProjectTest() {
//        Project project = new Project();
        DashboardPage dashboardPage = new DashboardPage(driver,true);
        dashboardPage.openProject(project);

        ViewProjectPage viewProjectPage =new ViewProjectPage(driver);
        viewProjectPage.editProject();

        Assert.assertTrue(waits.waitForVisibility(By.cssSelector(".message.message-success")).isDisplayed());
        }

    @Test(dependsOnMethods = "loginTest", alwaysRun = true, priority = 2)
    public void deleteProjectTest(){
        AdminProjectsPage adminProjectsPage = new AdminProjectsPage(driver,true);
        adminProjectsPage.deleteProject(project);

    }
}
