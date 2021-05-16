package models;

import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
@Builder
public class Project {


    int id;
    String name;
    String announcement;
    boolean isShowAnnouncement;
    ProjectType type;
}
