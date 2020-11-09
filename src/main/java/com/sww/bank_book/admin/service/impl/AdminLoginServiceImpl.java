package com.sww.bank_book.admin.service.impl;

import com.sww.bank_book.admin.dao.AdminLoginDao;
import com.sww.bank_book.admin.entity.Admin;
import com.sww.bank_book.admin.entity.CategoryNameList;
import com.sww.bank_book.admin.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/19
 * @description
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginDao adminLoginDao;

    @Override
    public Integer adminLogin(String adminName,String adminPassword) {
        if(adminName!=null && adminPassword !=null){
            Admin admin = adminLoginDao.adminLogin(adminName,adminPassword);
           if(admin != null){
               // 登录成功
               return 0;
           }
                // 登录失败
                return -1;
        }else {
            // 登录失败
            return -1;
        }
    }

    @Override
    public List<CategoryNameList> findBookCategoryOfNumber() {
        return adminLoginDao.findBookCategoryOfNumber();
    }
}
