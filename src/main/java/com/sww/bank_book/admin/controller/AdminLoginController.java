package com.sww.bank_book.admin.controller;

import com.sww.bank_book.admin.entity.Admin;
import com.sww.bank_book.admin.entity.CategoryNameList;
import com.sww.bank_book.admin.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/19
 * @description
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping(value = "/adminLogin")
    public Map<String,String> adminLogin(Admin admin){
        Map<String,String> map = new HashMap<>();
        Integer result = adminLoginService.adminLogin(admin.getAdminName(),admin.getAdminPassword());
        if(result !=0){
            map.put("code",result+"");
            map.put("msg","用户名或密码错误!");
        }else{
            map.put("code","1");
            map.put("msg","登录成功!");
        }
        return map;
    }



    @RequestMapping(value = "/findBookCategoryOfNumber")
    public List<CategoryNameList> findBookCategoryOfNumber(){
        List<CategoryNameList> categoryNameLists = adminLoginService.findBookCategoryOfNumber();
      return categoryNameLists;
    }
}
