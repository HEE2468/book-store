package com.sww.bank_book.books.controller;

import com.sww.bank_book.books.entity.BookClass;
import com.sww.bank_book.books.service.BookClassService;
import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
@RestController
@RequestMapping("/book")
public class BookClassController {

    @Autowired
    private BookClassService bookClassService;

    @RequestMapping(value = "/findBookClass")
    public JSONObject<BookClass> findBookClass(@RequestBody Map<String,String> bookCategory){

        JSONObject<BookClass> jsonObject = new JSONObject<>();
        List<BookClass> bookClassList = bookClassService.findBookClass(bookCategory.get("bookCategoryId"));

        if(bookClassList.size()!=0){
            jsonObject.setList(bookClassList);
            jsonObject.setCode(200);
            jsonObject.setMsg("查找成功");
        }else{
            jsonObject.setCode(504);
            jsonObject.setMsg("查找失败");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/findClassIdByOrder")
    public JSONObject findClassIdByOrder(@RequestBody Map<String,String> bookCategory){

        String bookClassId= bookClassService.findClassIdByOrder(bookCategory.get("bookCategoryId"));

        if(bookClassId != null){
            return new JSONObject(null,bookClassId,200,"查找成功");
        }else{
            return new JSONObject(null,null,500,"查找成功");
        }
    }

}
