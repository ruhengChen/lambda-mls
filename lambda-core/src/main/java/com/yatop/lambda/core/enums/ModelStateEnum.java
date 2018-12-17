package com.yatop.lambda.core.enums;

public enum ModelStateEnum {

    /**
     * 模型
     */
    EMPTY(0, "Empty"),

    /**
     * 正常
     */
    NORMAL(1, "Normal");

    private int state;
    private String name;

    ModelStateEnum(int state, String name) {
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
}
