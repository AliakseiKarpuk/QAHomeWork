package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TestCase {

    String projectName;
    String testCaseName;
    String newTestCaseName;
    String stepText;
    String expectedResultText;
    String preconditionText;

}
