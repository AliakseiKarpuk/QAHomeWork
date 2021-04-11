package testData;

import org.testng.annotations.DataProvider;

public class AddTestCaseProvider {

    @DataProvider(name = "Add Test Case")
    public static Object[][] addData(){
        return new Object[][]{
                {"AKarpuk_08", "first test case", "some precondition text", "some steps text", "expected result some text"},
                {"AKarpuk_08", "second test case",  "some precondition text in test case 2", "some steps text in test case 2", "expected result some text in test case 2"},
                {"AKarpuk_08", "third test case", "some precondition text in test case 3", "some steps text in test case 3", "expected result some text in test case 3"},
                {"AKarpuk_08", "fourst test case", "some precondition text in test case 4", "some steps text in test case 4", "expected result some text in test case 4"},

        };
    }

    @DataProvider(name = "Update Test Case")
    public static Object[][] updateData(){
        return new Object[][]{
                {"AKarpuk_08", "first test case","UPDATED FIRST CASE", "updated some precondition text", "updated some steps text", "updated expected result some text"},
                {"AKarpuk_08", "second test case","UPDATED SECOND CASE", "updated some precondition text", "updated some steps text", "updated expected result some text"},
                {"AKarpuk_08", "third test case","UPDATED THIRD CASE", "updated some precondition text", "updated some steps text", "updated expected result some text"},
                {"AKarpuk_08", "fourst test case","UPDATED FOURST CASE", "updated some precondition text", "updated some steps text", "updated expected result some text"}
        };
    }
    @DataProvider(name = "Delete Test Case")
    public static Object[][] deleteData() {
        return new Object[][]{
                {"AKarpuk_08", "UPDATED FIRST CASE"},
                {"AKarpuk_08", "UPDATED SECOND CASE"},
                {"AKarpuk_08", "UPDATED THIRD CASE"},
                {"AKarpuk_08", "UPDATED FOURST CASE"}
        };
    }
}
