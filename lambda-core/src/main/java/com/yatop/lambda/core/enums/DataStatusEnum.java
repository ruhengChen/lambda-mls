package com.yatop.lambda.core.enums;

public enum DataStatusEnum {

    /**
     * 正常
     */
    NORMAL(0, "Normal"),

    /**
     * 失效
     */
    INVALID(1, "Invalid");

    private int status;
    private String name;

    DataStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
