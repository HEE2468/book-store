package com.sww.bank_book.center.dao;

import com.sww.bank_book.center.entity.UserManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
@Mapper
@Component(value = "UserManagerDao")
public interface UserManagerDao {

    UserManager findUserInfos(@Param("userId") String userId);

    Integer updateUserInfos(UserManager userManager);

    UserManager findUserPasswordById(@Param("userId") String userId);
}
