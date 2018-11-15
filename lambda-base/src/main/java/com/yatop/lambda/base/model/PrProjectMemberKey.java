package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "pr_project_member")
public class PrProjectMemberKey implements Serializable {
    /**
     * 项目ID
     */
    @Id
    @Column(name = "PROJECT_ID")
    private Long projectId;

    /**
     * 项目成员用户名
     */
    @Id
    @Column(name = "MEMBER_USER")
    private String memberUser;

    private static final long serialVersionUID = 1L;

    /**
     * 获取项目ID
     *
     * @return PROJECT_ID - 项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置项目ID
     *
     * @param projectId 项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取项目成员用户名
     *
     * @return MEMBER_USER - 项目成员用户名
     */
    public String getMemberUser() {
        return memberUser;
    }

    /**
     * 设置项目成员用户名
     *
     * @param memberUser 项目成员用户名
     */
    public void setMemberUser(String memberUser) {
        this.memberUser = memberUser == null ? null : memberUser.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PrProjectMemberKey other = (PrProjectMemberKey) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getMemberUser() == null ? other.getMemberUser() == null : this.getMemberUser().equals(other.getMemberUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getMemberUser() == null) ? 0 : getMemberUser().hashCode());
        return result;
    }
}