package com.yatop.lambda.core.enums;

public enum DataWarehouseTypeEnum {

    /**
     * 公共数据库
     */
    PUBLIC(0, "Public"),

    /**
     * 项目数据库
     */
    PROJECT(1, "Project");

    private int type;
    private String name;

    DataWarehouseTypeEnum(int type, String name) {
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

    public static DataWarehouseTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return PUBLIC;
            case 1: return PROJECT;
            default: return null;
        }
    }
}
