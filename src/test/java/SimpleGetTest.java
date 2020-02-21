import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestMethodFinder;
import org.testng.annotations.Test;
import utils.CsvFileNames;
import utils.data_providers.WeatherDataProvider;

public class SimpleGetTest {

    @Test
    public void getResponseBody(ITestMethodFinder f) {
        WeatherDataProvider weatherDataProvider = new WeatherDataProvider(CsvFileNames.WEATHER_CSV.getFileName());
        String city = weatherDataProvider.getWeatherData("getResponseBody").getCity();

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, city);

        String responseBody = response.getBody().asString();
        System.out.println("Response: \n" + responseBody);
    }
}
