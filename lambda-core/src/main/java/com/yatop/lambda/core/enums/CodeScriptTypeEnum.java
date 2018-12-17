package com.yatop.lambda.core.enums;

public enum CodeScriptTypeEnum {

    /**
     * SQl脚本
     */
    SQL(1, "SQL Script");

    /**
     * Python脚本
     */
    //PYTHON(2, "Python Script"),

    /**
     * R脚本
     */
    //R(3, "R Script"),

    /**
     * 特征抽取脚本
     */
    //FEATURE_EXTACT(4, "Feature Extract");

    private int type;
    private String name;

    CodeScriptTypeEnum(int type, String name) {
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
