package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    private String title;
    private String template;
    private String type;
    private String priority;
    private String estimate;
    private int milestone_id;
    private String references;
    private String mission;
    private String goals;
}
