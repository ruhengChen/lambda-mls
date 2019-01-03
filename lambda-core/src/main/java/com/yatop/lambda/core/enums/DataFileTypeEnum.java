package com.yatop.lambda.core.enums;

public enum DataFileTypeEnum {

    /**
     * Parquet数据文件类型
     */
    PARQUET(1, "Parquet");

    private int type;
    private String name;

    DataFileTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DataFileTypeEnum valueOf(int type) {
        switch (type) {
            case 1: return PARQUET;
            default: return null;
        }
    }
}
