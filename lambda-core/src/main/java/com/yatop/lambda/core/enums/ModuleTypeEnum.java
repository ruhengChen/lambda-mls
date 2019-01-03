package com.yatop.lambda.core.enums;

public enum ModuleTypeEnum {

    /**
     * 普通工作流组件（可拖拽到画布中）
     */
    GENERAL_WORKFLOW_MODULE(0, "General Workflow Module"),

    /**
     * 不进工作流组件（不可托到画布中，封装的计算组件无输入内容，无输出端口）
     */
    NON_WORKFLOW_MODULE(1, "Non Workflow Module");

    private int type;
    private String name;

    ModuleTypeEnum(int type, String name) {
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

    public static ModuleTypeEnum valueOf(int type) {
        switch (type) {
            case 0: return GENERAL_WORKFLOW_MODULE;
            case 1: return NON_WORKFLOW_MODULE;
            default: return null;
        }
    }
}
