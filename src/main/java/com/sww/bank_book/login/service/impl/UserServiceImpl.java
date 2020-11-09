package com.sww.bank_book.login.service.impl;

import com.sww.bank_book.login.dao.UserDao;
import com.sww.bank_book.login.entity.User;
import com.sww.bank_book.login.service.UserService;
import com.sww.bank_book.utils.EntityIDFactory;
import com.sww.bank_book.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author HEE
 * @date 2019/12/9
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        // 密码
        String oldPassword = password;
        String md5Before = MD5Util.getMD5_32(oldPassword);
        User userCheck = userDao.findPassword(username);
        if (userCheck == null) {
            return null;
        }
        String md5After = userCheck.getPassword();
        if (md5After.equals(md5Before)) {
            return userCheck;
        } else {
            return null;
        }
    }

    @Override
    public Integer insertUser(User user) {
        user.setId(EntityIDFactory.createId());
        // 用户名验重
        Integer isExitsNum = userDao.checkUserName(user.getUsername());
        if (isExitsNum > 0) {
            return 2;
        }
        User newUser = new User(user.getId(), user.getUsername(), MD5Util.getMD5_32(user.getPassword()), new Date());
        Integer insertCount = userDao.insertUser(newUser);
        if (insertCount <= 0) {
            return -1;
        }
        return 1;
    }
}
