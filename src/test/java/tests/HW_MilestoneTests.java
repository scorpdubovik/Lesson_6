package tests;

import baseEntity.BaseTest;
import enums.ProjectType;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HW_MilestoneTests extends BaseTest {
    Project project;
    public static String addProjectName;
    public static String addMilestoneName;

    @Test
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project101")
                .announcement("My project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();
        addProjectName = project.getName();

        projectSteps.addProject(project);
        $(".message.message-success").shouldBe(visible).shouldHave(text("Successfully added the new project."));
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

        milestoneSteps.createMilestone(project, milestone);
        $(".message.message-success").shouldBe(visible).shouldHave(text("Successfully added the new milestone."));
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

        milestoneSteps.updateMilestone(project, milestoneUpdated);
        $(".message.message-success").shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest", "updateMilestoneTest"})
    public void deleteMilestoneTest() {
        milestoneSteps.deleteMilestone();
        $(".message.message-success").shouldBe(visible).shouldHave(text("Successfully deleted the milestone (s)."));
    }
}