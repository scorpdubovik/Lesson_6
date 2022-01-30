package tests.api;

import baseEntity.BaseApiTest;
import enums.ProjectType;
import enums.TestCasePriority;
import enums.TestCaseTemplate;
import enums.TestCaseType;
import io.restassured.mapper.ObjectMapperType;
import models.ProjectBuilder;
import models.Section;
import models.TestCase;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class HW_TestCaseTest extends BaseApiTest {
    public int projectID;
    public int sectionID1;
    public int sectionID2;
    public int caseID;

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
    public void addSection1() {
        Section section = Section.builder()
                .name("MyProjectSection")
                .description("123")
                .build();

        sectionID1 = given()
                .pathParam("project_id", projectID)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().jsonPath().get("id");

        System.out.println(sectionID1);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1"})
    public void addSection2() {
        Section section = Section.builder()
                .name("MyProjectSection2")
                .description("789")
                .build();

        sectionID2 = given()
                .pathParam("project_id", projectID)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().jsonPath().get("id");

        System.out.println(sectionID2);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1"})
    public void addTestCase() {
        TestCase testCase = TestCase.builder()
                .title("Adding book to cart")
                .template(TestCaseTemplate.EXPLORATORY_SESSION)
                .type(TestCaseType.AUTOMATED)
                .priority(TestCasePriority.HIGH)
                .estimate("30s")
                .references("RF-1")
                .mission("Check cart functionality")
                .goals("Add some random books to the cart and check if they appeared in the cart")
                .build();

        caseID = given()
                .pathParam("section_id", sectionID1)
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().jsonPath().get("id");

        System.out.println(caseID);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1", "addTestCase"})
    public void getTestCase() {
        TestCase expectedTestCase = TestCase.builder()
                .title("Adding book to cart")
                .template(TestCaseTemplate.EXPLORATORY_SESSION)
                .type(TestCaseType.AUTOMATED)
                .priority(TestCasePriority.HIGH)
                .estimate("30s")
                .references("RF-1")
                .mission("Check cart functionality")
                .goals("Add some random books to the cart and check if they appeared in the cart")
                .build();

        TestCase result = given()
                .pathParam("case_id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class);

        assertThat("Users are equal", result.equals(expectedTestCase));
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1", "addTestCase"})
    public void updateTestCase() {
        TestCase testCase = TestCase.builder()
                .title("UPDATED adding book to cart")
                .template(TestCaseTemplate.TEST_CASE_STEPS)
                .type(TestCaseType.SMOKE_SANITY)
                .priority(TestCasePriority.MEDIUM)
                .estimate("1m")
                .references("RF-12")
                .build();

        given()
                .pathParam("case_id", caseID)
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1", "addSection2", "addTestCase"})
    public void moveTestCaseToSection() {
        given()
                .pathParam("section_id", sectionID2)
                .body(String.format("{\n" +
                        "  \"case_ids\": [" + caseID + "] \n" +
                        "}"))
                .log().body()
                .when()
                .post(Endpoints.MOVE_CASE_TO_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = {"addProjectTest", "addSection1", "addTestCase"}, priority = 2)
    public void deleteTestCase() {
        given()
                .pathParam("case_id", caseID)
                .when()
                .post(Endpoints.DEL_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
