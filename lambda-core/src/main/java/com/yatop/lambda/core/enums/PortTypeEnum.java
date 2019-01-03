package com.yatop.lambda.core.enums;

public enum PortTypeEnum {

    /**
     * 输入端口
     */
    INPUT_PORT(1, "Input Port"),

    /**
     * 输出端口
     */
    OUTPUT_PORT(2, "Output Port");

    private int type;
    private String name;

    PortTypeEnum(int type, String name) {
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

    public boolean isCorrectPortType(SpecTypeEnum specTypeEnum) {
        return (specTypeEnum == SpecTypeEnum.INPUT ? this == INPUT_PORT : (specTypeEnum == SpecTypeEnum.OUTPUT ? this == OUTPUT_PORT : false));
    }

    public static PortTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return INPUT_PORT;
            case 1: return OUTPUT_PORT;
            default: return null;
        }
    }
}
