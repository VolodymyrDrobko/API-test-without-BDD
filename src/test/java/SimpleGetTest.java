import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class SimpleGetTest {

    @Test
    public void getResponseBody() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "Lviv");

        String responseBody = response.getBody().asString();
        System.out.println("Response: \n" + responseBody);
    }
}
