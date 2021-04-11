package testData;

import enums.ProjectType;
import org.testng.annotations.DataProvider;

public class AddProjectProvider {

    @DataProvider(name = "Add Project")
    public static Object[][] AddData(){
        return new Object[][]{
                {"AKarpuk_01", ProjectType.SINGLE_FOR_ALL_CASES},
                {"AKarpuk_02", ProjectType.SINGLE_WITH_BASELINE},
                {"AKarpuk_03", ProjectType.MULTIPLE}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] UpdateData(){
        return new Object[][]{
                {"AKarpuk_01", ProjectType.MULTIPLE, "new_AKarpuk_01"},
                {"AKarpuk_02", ProjectType.SINGLE_FOR_ALL_CASES, "new_AKarpuk_02"},
                {"AKarpuk_03", ProjectType.SINGLE_WITH_BASELINE, "new_AKarpuk_03"}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] DeleteData(){
        return new Object[][]{
                {"new_AKarpuk_01"},
                {"new_AKarpuk_02"},
                {"new_AKarpuk_03"}
        };
    }
}
