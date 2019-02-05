package nl.hefty.datagenerator;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class Data {
    @JsonRawValue
    private String field;
    @JsonRawValue
    private String value;

    public Data(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
