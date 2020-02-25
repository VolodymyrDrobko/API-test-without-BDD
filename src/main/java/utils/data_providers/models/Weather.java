package utils.data_providers.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import lombok.Data;
import utils.data_providers.BlankDataFilter;

@Data
public class Weather {
    @PreAssignmentProcessor(processor = BlankDataFilter.class)
    @CsvBindByName(column = "TestCaseName")
    private String testCaseName;
    @PreAssignmentProcessor(processor = BlankDataFilter.class)
    @CsvBindByName(column = "City")
    private String city;
    @CsvBindByName(column = "Status code")
    private Integer statusCode;
    @PreAssignmentProcessor(processor = BlankDataFilter.class)
    @CsvBindByName(column = "Status message")
    private String statusMessage;
}
