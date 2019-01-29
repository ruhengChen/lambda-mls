package com.yatop.lambda.portal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pr_project_member")

public class PrProjectMember implements Serializable {

    private static final long serialVersionUID = 7323820231535870010L;

    /**
     * 项目ID
     */
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    /**
     * 是否为项目所有者
            0：一般成员（multiple）
            1：项目所有者（only one）
            2：项目维护者（multiple）
     */
    @Column(name = "PROJECT_ROLE")
    private Integer projectRole;

    /**
     * 项目成员用户名
     */
    @Column(name = "MEMBER_USER")
    private String memberUser;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
            0：正常
            1：失效
     */
    @Column(name = "STATUS")
    private Integer status;

    /**
     * 最后更新时间
     */
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;

    /**
     * 最后更新用户
     */
    @Column(name = "LAST_UPDATE_OPER")
    private String lastUpdateOper;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建用户
     */
    @Column(name = "CREATE_OPER")
    private String createOper;

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
     * 获取是否为项目所有者
            0：一般成员（multiple）
            1：项目所有者（only one）
            2：项目维护者（multiple）
     *
     * @return PROJECT_ROLE - 是否为项目所有者
            0：一般成员（multiple）
            1：项目所有者（only one）
            2：项目维护者（multiple）
     */
    public Integer getProjectRole() {
        return projectRole;
    }

    /**
     * 设置是否为项目所有者
            0：一般成员（multiple）
            1：项目所有者（only one）
            2：项目维护者（multiple）
     *
     * @param projectRole 是否为项目所有者
            0：一般成员（multiple）
            1：项目所有者（only one）
            2：项目维护者（multiple）
     */
    public void setProjectRole(Integer projectRole) {
        this.projectRole = projectRole;
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

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态
            0：正常
            1：失效
     *
     * @return STATUS - 状态
            0：正常
            1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
            0：正常
            1：失效
     *
     * @param status 状态
            0：正常
            1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后更新时间
     *
     * @return LAST_UPDATE_TIME - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取最后更新用户
     *
     * @return LAST_UPDATE_OPER - 最后更新用户
     */
    public String getLastUpdateOper() {
        return lastUpdateOper;
    }

    /**
     * 设置最后更新用户
     *
     * @param lastUpdateOper 最后更新用户
     */
    public void setLastUpdateOper(String lastUpdateOper) {
        this.lastUpdateOper = lastUpdateOper == null ? null : lastUpdateOper.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建用户
     *
     * @return CREATE_OPER - 创建用户
     */
    public String getCreateOper() {
        return createOper;
    }

    /**
     * 设置创建用户
     *
     * @param createOper 创建用户
     */
    public void setCreateOper(String createOper) {
        this.createOper = createOper == null ? null : createOper.trim();
    }
}