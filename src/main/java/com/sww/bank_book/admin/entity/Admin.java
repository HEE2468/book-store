package com.sww.bank_book.admin.entity;

/**
 * @author HEE
 * @date 2020/10/19
 * @description
 */
public class Admin {

    private String adminId;
    private String adminName;
    private String adminPassword;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
