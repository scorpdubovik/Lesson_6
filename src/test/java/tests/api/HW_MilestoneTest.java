package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HW_MilestoneTest extends BaseApiTest {
    public int projectID;
    public int milestoneID;

    @Test
    public void addProjectTest() {
        ProjectBuilder project = ProjectBuilder.builder()
                .name("Project007")
                .announcement("My project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(projectID);
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Sprint1")
                .description("My new Milestone")
                .references("TR-1")
                .startDate(1643529622)
                .endDate(1643729422)
                .build();

        milestoneID = given()
                .pathParam("project_id", projectID)
                .body(milestone, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().jsonPath().get("id");

        System.out.println(milestoneID);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest"})
    public void getMilestonesTest() {
        Milestone expectedMilestone = Milestone.builder()
                .name("Sprint1")
                .description("My new Milestone")
                .references("TR-1")
                .startDate(1643529622)
                .endDate(1643729422)
                .build();

        given()
                .pathParam("project_id", projectID)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("milestones[0].name", is(expectedMilestone.getName()))
                .body("milestones[0].description", equalTo(expectedMilestone.getDescription()));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest"})
    public void updateMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Sprint1 Updated")
                .description("My updated Milestone")
                .references("Updated")
                .startDate(1643616898)
                .endDate(1644088498)
                .isCompleted(true)
                .build();

        given()
                .pathParam("milestone_id", milestoneID)
                .body(milestone, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(milestone.getName()));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addMilestoneTest"}, priority = 2)
    public void deleteMilestoneTest() {
        given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(Endpoints.DEL_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
