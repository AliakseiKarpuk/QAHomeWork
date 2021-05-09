package testData;

import enums.ProjectType;
import org.testng.annotations.DataProvider;

public class AddProjectProvider {

    @DataProvider(name = "Add Project")
    public static Object[][] AddData(){
        return new Object[][]{
                {"AKarpuk_01", " 12321321321", "1"},
                {"AKarpuk_02", " 12321321321", "2"},
                {"AKarpuk_03", " 12321321321", "3"}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] UpdateData(){
        return new Object[][]{
                {"AKarpuk_01", "new_AKarpuk_01"},
                {"AKarpuk_02", "new_AKarpuk_02"},
                {"AKarpuk_03", "new_AKarpuk_03"}
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
