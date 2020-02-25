package utils.data_providers;

import com.opencsv.bean.processor.StringProcessor;

public class BlankDataFilter implements StringProcessor {
    private String defaultValue;

    @Override
    public String processString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    @Override
    public void setParameterString(String value) {
        defaultValue = value;
    }
}
