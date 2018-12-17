package com.yatop.lambda.core.enums;

public enum ProjectRoleEnum {

    /**
     * 一般成员
     */
    GENERAL_MEMBER(0, "General"),

    /**
     * 项目所有者
     */
    PROJECT_OWNER(1, "Owner"),

    /**
     * 项目维护者
     */
    PROJECT_MAINTAINER(2, "Maintainer");

    private int role;
    private String name;

    ProjectRoleEnum(int tag, String name) {
        this.role = tag;
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int tag) {
        this.role = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
