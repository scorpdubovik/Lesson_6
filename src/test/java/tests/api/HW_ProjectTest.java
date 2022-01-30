package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class HW_ProjectTest extends BaseApiTest {
    public int projectID;

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
    public void updateProjectTest() {
        ProjectBuilder projectUpd = ProjectBuilder.builder()
                .name("Project007UPD")
                .announcement("My project UPD")
                .isShowAnnouncement(false)
                .isCompleted(true)
                .build();

        Response response = given()
                .pathParam("project_id", projectID)
                .body(projectUpd, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),
                projectUpd.getName());
    }

    @Test(dependsOnMethods = "addProjectTest", priority = 2)
    public void deleteProjectTest() {
        given()
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.DEL_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
