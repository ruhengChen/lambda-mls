package com.yatop.lambda.core.enums;

public enum CodeScriptStateEnum {

    /**
     * 空脚本
     */
    EMPTY(0, "Empty"),

    /**
     * 正常
     */
    NORMAL(1, "Normal");

    private int state;
    private String name;

    CodeScriptStateEnum(int state, String name) {
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

    public static CodeScriptStateEnum valueOf(int state) {
        switch (state) {
            case 0: return EMPTY;
            case 1: return NORMAL;
            default: return null;
        }
    }
}
