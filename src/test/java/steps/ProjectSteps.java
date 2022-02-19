package steps;

import models.Project;
import pages.AddProjectPage;
import pages.DashboardPage;

public class ProjectSteps {
    private AddProjectPage addProjectPage = new AddProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();

    public AddProjectPage addProject(Project project) {
        dashboardPage.getAddProjectButton().click();

        addProjectPage.getNameField().val(project.getName());
        addProjectPage.getAnnouncementField().val(project.getAnnouncement());
        if (project.isShowAnnouncement()) {addProjectPage.showAnnouncement();}
        addProjectPage.setType(project.getTypeOfProject());
        addProjectPage.getCreateProjectButton().click();

        return addProjectPage;
    }

    public void updateProject(Project currentProject, Project newProject) {

    }

    public void deleteProject(Project project) {

    }
}
