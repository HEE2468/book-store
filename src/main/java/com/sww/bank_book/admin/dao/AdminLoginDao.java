package com.sww.bank_book.admin.dao;

import com.sww.bank_book.admin.entity.Admin;
import com.sww.bank_book.admin.entity.CategoryNameList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/19
 * @description
 */
@Mapper
@Component(value = "AdminLoginDao")
public interface AdminLoginDao {

    Admin adminLogin(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

    /**
     * 后台 显示书籍类别：书籍数量
     * @return
     */
    List<CategoryNameList> findBookCategoryOfNumber();
}
