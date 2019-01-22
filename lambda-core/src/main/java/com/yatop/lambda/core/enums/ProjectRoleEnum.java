package com.yatop.lambda.core.enums;

public enum ProjectRoleEnum {

    /**
     * 所有者
     */
    PROJECT_OWNER(0, "Project Owner"),

    /**
     * 维护者
     */
    PROJECT_MAINTAINER(1, "Project Maintainer"),

    /**
     * 开发者
     */
    PROJECT_DEVELOPER(2, "Project Developer");

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
            case 0: return PROJECT_DEVELOPER;
            case 1: return PROJECT_OWNER;
            case 2: return PROJECT_MAINTAINER;
            default: return null;
        }
    }
}
