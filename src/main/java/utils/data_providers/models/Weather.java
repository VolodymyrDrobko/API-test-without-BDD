package utils.data_providers.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Weather {
    @CsvBindByName(column = "TestCaseName")
    private String testCaseName;
    @CsvBindByName(column = "City")
    private String city;
}
