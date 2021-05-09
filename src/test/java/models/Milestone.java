package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Milestone {


    String name;
    int projectId;
    int dueOn;
    boolean isCompleted;
    boolean isStarted;
    String description;

}
