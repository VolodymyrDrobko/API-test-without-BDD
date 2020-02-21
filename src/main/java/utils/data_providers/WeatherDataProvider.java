package utils.data_providers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import utils.data_providers.models.Weather;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WeatherDataProvider {
    private String fileLocation = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
            File.separator + "resources" + File.separator + "test_data" + File.separator;

    public WeatherDataProvider(String fileName) {
        fileLocation += fileName;
    }

    public Weather getWeatherData(String testCaseName) {
        try (FileReader reader = new FileReader(fileLocation)) {
        CsvToBean<Weather> csvToBean = new CsvToBeanBuilder<Weather>(reader)
                .withSeparator(';')
                .withType(Weather.class)
                .build();
        Weather weatherActual = csvToBean.parse().stream()
                .filter(weather -> testCaseName.equals(weather.getTestCaseName())).findFirst().get();
        return weatherActual;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
