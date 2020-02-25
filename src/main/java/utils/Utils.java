package utils;

public class Utils {
    public static String getTestCaseName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
