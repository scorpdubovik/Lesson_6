package tests;

import baseEntity.BaseTest;
import enums.ProjectType;
import models.Project;
import models.TestCase;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddTestCasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HW_TestCaseTests extends BaseTest {
    Project project;
    public static String addProjectName1;
    public static String addTestCaseName;
    private AddProjectPage addProjectPage;
    private AddTestCasePage addTestCasePage;

    @Test
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project102")
                .announcement("My project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();
        addProjectName1 = project.getName();

        addProjectPage = projectSteps.addProject(project);
        addProjectPage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addTestCase() {
        TestCase testCase = TestCase.builder()
                .title("Adding book to cart")
                .estimate("30s")
                .references("RF-1")
                .build();
        addTestCaseName = testCase.getTitle();

        addTestCasePage = testCaseSteps.addTestCase(project, testCase);
        addTestCasePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully added the new test case."));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addTestCase"})
    public void updateTestCase() {
        TestCase updateTestCase = TestCase.builder()
                .title("UPDATED adding book to cart")
                .estimate("1m")
                .references("RF-12")
                .build();

        addTestCasePage = testCaseSteps.updateTestCase(project, updateTestCase);
        addTestCasePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addTestCase"})
    public void deleteTestCase() {
        addTestCasePage = testCaseSteps.deleteTestCase();
        addTestCasePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }
}