package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    private String title;
    @SerializedName(value = "template_id")
    private int template;
    @SerializedName(value = "type_id")
    private int type;
    @SerializedName(value = "priority_id")
    private int priority;
    private String estimate;
    private int milestone_id;
    @SerializedName(value = "refs")
    private String references;
    @SerializedName(value = "custom_mission")
    private String mission;
    @SerializedName(value = "custom_goals")
    private String goals;
}
