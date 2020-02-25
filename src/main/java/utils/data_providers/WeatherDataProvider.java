package utils.data_providers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import utils.data_providers.models.Weather;

import java.io.FileReader;
import java.io.IOException;

public class WeatherDataProvider extends DataProvider {

    public WeatherDataProvider(String fileName) {
        super(fileName);
    }

    public Weather getWeatherData(String testCaseName) {
        try (FileReader reader = new FileReader(fileLocation)) {
        CsvToBean<Weather> csvToBean = new CsvToBeanBuilder<Weather>(reader)
                .withType(Weather.class)
                .build();
        Weather weatherActual = csvToBean.stream()
                .filter(weather -> testCaseName.equals(weather.getTestCaseName())).findFirst().get();
        return weatherActual;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
