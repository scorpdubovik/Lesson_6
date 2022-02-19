package tests;

import baseEntity.BaseTest;
import enums.ProjectType;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.MilestonePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class HW_MilestoneTests extends BaseTest {
    Project project;
    public static String addProjectName;
    public static String addMilestoneName;
    private MilestonePage milestonePage;
    private AddProjectPage addProjectPage;

    @Test
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project1011")
                .announcement("My project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();
        addProjectName = project.getName();

        addProjectPage = projectSteps.addProject(project);
        addProjectPage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Sprint1")
                .description("My new Milestone")
                .references("TR-1")
                .startDate("2/14/2022")
                .endDate("2/25/2022")
                .build();
        addMilestoneName = milestone.getName();

        milestonePage = milestoneSteps.addMilestone(project, milestone);
        milestonePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully added the new milestone."));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest"})
    public void updateMilestoneTest() {
        Milestone milestoneUpdated = Milestone.builder()
                .name("Sprint1 Updated")
                .description("My updated Milestone")
                .references("Updated")
                .startDate("2/10/2022")
                .endDate("2/28/2022")
                .build();

        milestonePage = milestoneSteps.updateMilestone(project, milestoneUpdated);
        milestonePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest", "updateMilestoneTest"})
    public void deleteMilestoneTest() {
        milestonePage = milestoneSteps.deleteMilestone();
        milestonePage.getSuccessField().shouldBe(visible).shouldHave(text("Successfully deleted the milestone (s)."));
    }
}