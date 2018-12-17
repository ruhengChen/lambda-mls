package com.yatop.lambda.core.enums;

public enum SpecMaskEnum {

    /**
     * 输入规格
     */
    INPUT(0x01, "Input Specification"),

    /**
     * 输出规格
     */
    OUTPUT(0x02, "Output Specification"),

    /**
     * 调用执行规格
     */
    EXECUTION(0x04, "Execution Specification"),

    /**
     * 执行优化规格
     */
    OPTIMIZE_EXECUTION(0x08, "Optimze Execution Specification"),

    /**
     * 组件参数规格
     */
    PARAMETER(0x10, "Parameter Specification");

    private int bit;
    private String name;

    SpecMaskEnum(int bit, String name) {
        this.bit = bit;
        this.name = name;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
