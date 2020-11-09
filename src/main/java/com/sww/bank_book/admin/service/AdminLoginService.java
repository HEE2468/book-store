package com.sww.bank_book.admin.service;

import com.sww.bank_book.admin.entity.CategoryNameList;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/19
 * @description
 */
public interface AdminLoginService {

    Integer adminLogin(String adminName,String adminPassword);

    /**
     * 后台 显示书籍类别：书籍数量
     * @return
     */
    List<CategoryNameList> findBookCategoryOfNumber();
}
