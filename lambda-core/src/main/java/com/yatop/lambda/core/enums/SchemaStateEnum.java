package com.yatop.lambda.core.enums;

public enum SchemaStateEnum {

    /**
     * 空schema
     */
    EMPTY(0, "Empty"),

    /**
     * 正常
     */
    NORMAL(1, "Normal"),

    /**
     * 不支持
     */
    NOT_SUPPORT(2, "Not Support"),

    /**
     * 超限中断
     */
    OVERLOAD_INTERRUPT(3, "Overload Interrupt");

    private int state;
    private String name;

    SchemaStateEnum(int state, String name) {
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

    public static SchemaStateEnum valueOf(int state) {
        switch (state) {
            case 0: return EMPTY;
            case 1: return NORMAL;
            case 2: return NOT_SUPPORT;
            case 3: return OVERLOAD_INTERRUPT;
            default: return null;
        }
    }
}
