package com.legend.account.entity;

import com.legend.net.entity.BaseResponse;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/18 0018
 * @描述：用户数据模型
 */
public class UserEntity extends BaseResponse<UserEntity> {
    private String loginName;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String userType;
    private String loginIp;
    private String loginDate;
    private String loginFlagx;
    private String photo;
    private String oldLoginIp;
    private String oldLoginDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginFlagx() {
        return loginFlagx;
    }

    public void setLoginFlagx(String loginFlagx) {
        this.loginFlagx = loginFlagx;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOldLoginIp() {
        return oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }

    public String getOldLoginDate() {
        return oldLoginDate;
    }

    public void setOldLoginDate(String oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
    }
}
