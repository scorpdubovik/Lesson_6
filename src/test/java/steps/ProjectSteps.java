package steps;

import models.Project;
import pages.AddProjectPage;
import pages.DashboardPage;

public class ProjectSteps {
    private AddProjectPage addProjectPage;

    public void addProject(Project project) {
        AddProjectPage addProjectPage = new AddProjectPage();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getAddProjectButton().click();

        addProjectPage.getNameField().val(project.getName());
        addProjectPage.getAnnouncementField().val(project.getAnnouncement());
        if (project.isShowAnnouncement()) {addProjectPage.showAnnouncement();}
        addProjectPage.setType(project.getTypeOfProject());
        addProjectPage.getCreateProjectButton().click();

    }

    public void updateProject(Project currentProject, Project newProject) {

    }

    public void deleteProject(Project project) {

    }
}
