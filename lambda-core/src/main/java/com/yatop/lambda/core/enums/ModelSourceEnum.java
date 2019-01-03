package com.yatop.lambda.core.enums;

public enum ModelSourceEnum {

    /**
     * 上传导入模型
     */
    IMPORT(0, "Import External Model"),

    /**
     * 保存临时模型
     */
    SAVE(1, "Save Temporary Model"),

    /**
     * 任务运行输出
     */
    EXECUTION(2, "Execution Task Output Model");

    private int source;
    private String name;

    ModelSourceEnum(int source, String name) {
        this.source = source;
        this.name = name;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ModelSourceEnum valueOf(int source) {
        switch (source) {
            case 0: return IMPORT;
            case 1: return SAVE;
            case 2: return EXECUTION;
            default: return null;
        }
    }
}
