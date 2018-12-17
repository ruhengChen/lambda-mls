package com.yatop.lambda.core.enums;

public enum StorageLocationEnum {

    /**
     * 表字段OBJECT_DATA
     */
    TABLE(0, "Table.Object_Data"),

    /**
     * 文件系统
     */
    FILESYSTEM(1, "File System");

    private int location;
    private String name;

    StorageLocationEnum(int tag, String name) {
        this.location = tag;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int tag) {
        this.location = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
