package models;

import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class Project {

    String name;
    String newName;
    String announcement;
    boolean isShowAnnouncement;
    String value;

}
