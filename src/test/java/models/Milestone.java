package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    private String name;
    private String description;
    private String endDate;
    private String references;
    private String startDate;
    private boolean isStarted;
    private boolean isCompleted;
}
