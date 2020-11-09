package com.sww.bank_book.login.dao;

import com.sww.bank_book.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author HEE
 * @date 2019/12/9
 * @description
 */
@Mapper
@Component(value = "UserDao")
public interface UserDao {

    /**
     * 用户登录
     * @param username
     * @return
     */
    User findPassword(String username);

    Integer insertUser(User user);

    Integer checkUserName(@Param("username") String username);
}
