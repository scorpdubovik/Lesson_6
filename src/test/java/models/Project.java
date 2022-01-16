package models;

import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Project {
    private String projectName1 = ReadProperties.getProjectName1();
    private String projectName2 = ReadProperties.getProjectName2();
    private String projectName3 = ReadProperties.getProjectName3();
    private String announcement = ReadProperties.getAnnouncement();
    private String radioButton1 = ReadProperties.getRadioButton1();
    private String radioButton2 = ReadProperties.getRadioButton2();
    private String radioButton3 = ReadProperties.getRadioButton3();

    public Project() {
    }

    public String getProjectName() {
        Random random = new Random();
        List<String> projectNames = new ArrayList<>();
        projectNames.add(projectName1);
        projectNames.add(projectName2);
        projectNames.add(projectName3);
        String projectName =projectNames.get(random.nextInt(3));
        return projectName;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public String getRadioButton_Selector() {
        Random random = new Random();
        List<String> type = new ArrayList<>();
        type.add(radioButton1);
        type.add(radioButton2);
        type.add(radioButton3);
        String typeOfProject  = type.get(random.nextInt(3));
        return typeOfProject;
    }
}
