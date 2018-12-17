package com.yatop.lambda.core.enums;

public enum ModelWarehouseTypeEnum {

    /**
     * 公共模型库
     */
    PUBLIC(0, "Public"),

    /**
     * 项目模型库
     */
    PROJECT(1, "Project");

    private int type;
    private String name;

    ModelWarehouseTypeEnum(int type, String name) {
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
}
