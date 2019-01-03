package com.yatop.lambda.core.enums;

public enum DataTableStateEnum {

    /**
     * 空表
     */
    EMPTY(0, "Empty"),

    /**
     * 正常
     */
    NORMAL(1, "Normal"),

    /**
     * 仅概要文件
     */
    ONLY_SUMMARY(2, "Only Summary");

    private int state;
    private String name;

    DataTableStateEnum(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DataTableStateEnum valueOf(int state) {
        switch (state) {
            case 0: return EMPTY;
            case 1: return NORMAL;
            case 2: return ONLY_SUMMARY;
            default: return null;
        }
    }
}
