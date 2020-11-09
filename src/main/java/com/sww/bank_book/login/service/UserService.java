package com.sww.bank_book.login.service;

import com.sww.bank_book.login.entity.User;

/**
 * @author HEE
 * @date 2019/12/9
 * @description
 */
public interface UserService {

    User login(String username, String password);

    Integer insertUser(User user);
}
