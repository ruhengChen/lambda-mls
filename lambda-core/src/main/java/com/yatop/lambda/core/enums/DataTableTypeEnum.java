package com.yatop.lambda.core.enums;

public enum DataTableTypeEnum {

    /**
     * 普通数据表
     */
    GENERAL(0, "General"),

    /**
     * 临时数据表
     */
    CACHED(1, "Cached"),

    /**
     * 外部数据表
     */
    EXTERNAL(2, "External");

    private int type;
    private String name;

    DataTableTypeEnum(int type, String name) {
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

    public static DataTableTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return GENERAL;
            case 1: return CACHED;
            case 2: return EXTERNAL;
            default: return null;
        }
    }
}
