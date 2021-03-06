package com.yatop.lambda.base.extend.model;


import com.yatop.lambda.base.model.PrProjectMember;


public class ProjectMemberWithUser extends PrProjectMember {

    private static final long serialVersionUID = -8078831798548519162L;
    private String username;
    private String email;
    private String mobile;
    private String userStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
