package com.sww.bank_book.login.entity;

import java.util.Date;

/**
 * @author HEE
 * @date 2019/12/9
 * @description
 */
public class User {

   private String id;
   private String username;
   private String password;
   private String img;
   private Integer sex;
   private Date registerDate;


   public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, Date registerDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


}
