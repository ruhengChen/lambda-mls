package com.yatop.lambda.core.enums;

public enum ExperimentTypeEnum {

    /**
     * 主实验
     */
    MAIN(0, "Main"),

    /**
     * 预测实验
     */
    PREDICTION(1, "Prediction");

    private int type;
    private String name;

    ExperimentTypeEnum(int type, String name) {
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
