package com.yatop.lambda.core.enums;

public enum SpecTypeEnum {

    /**
     * 输入规格
     */
    INPUT(1, "Input Specification"),

    /**
     * 输出规格
     */
    OUTPUT(2, "Output Specification"),

    /**
     * 调用执行规格
     */
    EXECUTION(3, "Execution Specification"),

    /**
     * 执行优化规格
     */
    OPTIMIZE_EXECUTION(4, "Optimze Execution Specification"),

    /**
     * 组件参数规格
     */
    PARAMETER(5, "Parameter Specification");

    private int type;
    private String name;

    SpecTypeEnum(int type, String name) {
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

    public static SpecTypeEnum valueOf(int type) {
        switch (type) {
            case 1: return INPUT;
            case 2: return OUTPUT;
            case 3: return EXECUTION;
            case 4: return OPTIMIZE_EXECUTION;
            case 5: return PARAMETER;
            default: return null;
        }
    }
}
