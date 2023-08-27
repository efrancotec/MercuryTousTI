package Test;
import org.testng.annotations.DataProvider;

public class DataProviderEx {

    @DataProvider(name = "LoginDataProvider")
    public static Object[][] getData(){
        Object[][] data = { {"admin", "admin"}, {"esteban1", "esteban1"}};

        return data;
    }
}
