import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.hamcrest.core.StringContains;
import org.testng.annotations.Test;
import utils.CsvFileNames;
import utils.data_providers.WeatherDataProvider;
import utils.data_providers.models.Weather;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Endpoints.BASE_URL;
import static utils.Utils.getTestCaseName;

public class SimpleGetTest {

    @Test
    public void getResponseBody() {
        String testCaseName = getTestCaseName();
        Weather expectedWeather = new WeatherDataProvider(CsvFileNames.WEATHER_CSV.getFileName()).getWeatherData(testCaseName);

        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, expectedWeather.getCity());

        String responseBody = response.getBody().asString();
        assertThat(responseBody, StringContains.containsStringIgnoringCase(expectedWeather.getCity()));
        System.out.println("Response: \n" + responseBody);

        assertThat("Verify response status code", response.getStatusCode(), Is.is(expectedWeather.getStatusCode()));
        assertThat("Verify response message code", response.getStatusLine(), StringContains.containsString(expectedWeather.getStatusMessage()));

        System.out.println("\nResponse headers:\n");
        response.getHeaders().forEach(header -> System.out.println(header));
        assertThat("Verify City response header", response.getHeader("Content-Type"), StringContains.containsString("json"));
    }
}
