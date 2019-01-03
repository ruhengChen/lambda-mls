package com.yatop.lambda.core.enums;

public enum DataTableSourceEnum {

    /**
     * 上传导入数据表
     */
    IMPORT(0, "Import External Data-Table"),

    /**
     * 保存临时数据表
     */
    SAVE(1, "Save Temporary Data-Table"),

    /**
     * 任务运行输出
     */
    EXECUTION(2, "Execution Task Output Data-Table");

    private int source;
    private String name;

    DataTableSourceEnum(int source, String name) {
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

    public static DataTableSourceEnum valueOf(int source) {
        switch (source) {
            case 0: return IMPORT;
            case 1: return SAVE;
            case 2: return EXECUTION;
            default: return null;
        }
    }
}
