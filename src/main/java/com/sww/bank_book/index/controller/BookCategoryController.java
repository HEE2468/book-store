package com.sww.bank_book.index.controller;

import com.sww.bank_book.index.entity.BookCategory;
import com.sww.bank_book.index.service.BookCategoryService;
import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */
@RestController
@RequestMapping("/category")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @RequestMapping(value = "/bookCategory")
    public JSONObject findBookCategory(){

        JSONObject<BookCategory> jsonObject = new JSONObject<>();
        List<BookCategory> categoryList = bookCategoryService.findBookCategory();

        if(categoryList!=null){
            jsonObject.setCode(200);
            jsonObject.setMsg("查询成功");
            jsonObject.setList(categoryList);
        }else{
            jsonObject.setCode(504);
            jsonObject.setMsg("查询失败");
        }
        return jsonObject;
    }

}
