package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.istack.NotNull;
import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Builder
@Data
@Accessors(chain = true)
public class Project {
    @Expose(serialize = false)
    @EqualsAndHashCode.Exclude
    private int id;
    @NotNull
    @Expose
    private String name;
    @Expose
    private String announcement;
    @Expose
    @SerializedName(value = "show_announcement")
    private boolean isShowAnnouncement;
    @Expose
    @SerializedName(value = "suite_mode")
    private int type;
    @Expose(serialize = false)
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    @Expose(serialize = false)
    @SerializedName(value = "completed_on")
    private long completedOn;
    @Expose(serialize = false)
    @EqualsAndHashCode.Exclude
    private String url;
}
