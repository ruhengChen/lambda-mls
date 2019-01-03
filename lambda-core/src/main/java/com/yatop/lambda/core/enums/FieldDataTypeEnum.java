package com.yatop.lambda.core.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum FieldDataTypeEnum {

    /** Parquet to Platform
            INT32 -> Integer
            INT64 -> Long
            FLOAT -> Float
            DOUBLE -> Double
            INT96 -> Timestamp（Date, Datetime）
            BINARY -> String
    * */

    BOOLEAN (1,  "Boolean",     "boolean"),
    SHORT   (2,  "Short",       "short"),
    INTEGER (3,  "Integer",     "integer"),
    LONG    (4,  "Long",        "long"),
    FLOAT   (5,  "Float",       "float"),
    DOUBLE  (6,  "Double",      "double"),
    STRING  (7,  "String",      "string"),
    DATE    (8,  "Date",        "date"),
    DATETIME(9,  "Datetime",    "date");

    private int type;
    private String platform;    //platform field type name
    private String spark;       //spark field type name

    FieldDataTypeEnum(int type, String platform, String spark) {
        this.type = type;
        this.platform = platform;
        this.spark = spark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSpark() {
        return spark;
    }

    public void setSpark(String spark) {
        this.spark = spark;
    }

    public static FieldDataTypeEnum valueOf(int type) {
        switch (type) {
            case 1: return BOOLEAN;
            case 2: return SHORT;
            case 3: return INTEGER;
            case 4: return LONG;
            case 5: return FLOAT;
            case 6: return DOUBLE;
            case 7: return STRING;
            case 8: return DATE;
            case 9: return DATETIME;
            default: return null;
        }
    }

    private static TreeMap<String, FieldDataTypeEnum> FIELD_DATA_TYPES = new TreeMap<String, FieldDataTypeEnum>();
    static {
        FIELD_DATA_TYPES.put(BOOLEAN.getPlatform(), BOOLEAN);
        FIELD_DATA_TYPES.put(SHORT.getPlatform(), SHORT);
        FIELD_DATA_TYPES.put(INTEGER.getPlatform(), INTEGER);
        FIELD_DATA_TYPES.put(LONG.getPlatform(), LONG);
        FIELD_DATA_TYPES.put(FLOAT.getPlatform(), FLOAT);
        FIELD_DATA_TYPES.put(DOUBLE.getPlatform(), DOUBLE);
        FIELD_DATA_TYPES.put(STRING.getPlatform(), STRING);
        FIELD_DATA_TYPES.put(DATE.getPlatform(), DATE);
        FIELD_DATA_TYPES.put(DATETIME.getPlatform(), DATETIME);

    }

    public static FieldDataTypeEnum valueOfPlatform(String platform) {
        return FIELD_DATA_TYPES.get(platform);
    }

    public static List<FieldDataTypeEnum> toList() {
        List<FieldDataTypeEnum> dataTypeEnums = new ArrayList<FieldDataTypeEnum>();
        for(Map.Entry<String, FieldDataTypeEnum> entry : FIELD_DATA_TYPES.entrySet()) {
            dataTypeEnums.add(entry.getValue());
        }

        return dataTypeEnums;
    }
}
