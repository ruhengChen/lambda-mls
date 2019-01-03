package com.yatop.lambda.core.enums;

public enum ProjectRoleEnum {

    /**
     * 一般成员
     */
    GENERAL_MEMBER(0, "General"),

    /**
     * 项目所有者
     */
    PROJECT_OWNER(1, "Owner");

    /**
     * 项目维护者
     */
    //PROJECT_MAINTAINER(2, "Maintainer");

    private int role;
    private String name;

    ProjectRoleEnum(int role, String name) {
        this.role = role;
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProjectRoleEnum valueOf(int role) {
        switch (role) {
            case 0: return GENERAL_MEMBER;
            case 1: return PROJECT_OWNER;
            //case 2: return PROJECT_MAINTAINER;
            default: return null;
        }
    }
}
