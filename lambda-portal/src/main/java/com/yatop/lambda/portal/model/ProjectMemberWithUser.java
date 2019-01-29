package com.yatop.lambda.portal.model;



/**
 * Created by 19016 on 2019/1/28.
 */
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
