package utils.data_providers;

import java.io.File;

public class DataProvider {
    protected String fileLocation = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
            File.separator + "resources" + File.separator + "test_data" + File.separator;

    public DataProvider(String fileName) {
        fileLocation += fileName;
    }
}
