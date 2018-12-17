package com.yatop.lambda.core.enums;

public enum ModelTypeEnum {

    /**
     * 普通模型
     */
    GENERAL(0, "General"),

    /**
     * 临时模型
     */
    CACHED(1, "Cached");

    /**
     * 外部模型
     */
  //EXTERNAL(2, "External");

    private int type;
    private String name;

    ModelTypeEnum(int type, String name) {
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
