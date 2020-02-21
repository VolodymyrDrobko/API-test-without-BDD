package utils;

public enum CsvFileNames {
    WEATHER_CSV("weather.csv");

    private String fileName;

    CsvFileNames(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
