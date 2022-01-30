package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    private String name;
    private String description;
    @SerializedName(value = "due_on")
    private int endDate;
    @SerializedName(value = "refs")
    private String references;
    @SerializedName(value = "start_on")
    private int startDate;
    @SerializedName(value = "is_started")
    private boolean isStarted;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
}
