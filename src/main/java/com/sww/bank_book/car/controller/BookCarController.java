package com.sww.bank_book.car.controller;

import com.sww.bank_book.car.entity.BookCar;
import com.sww.bank_book.car.service.BookCarService;
import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
@RestController
@RequestMapping("/car")
public class BookCarController {

    @Autowired
    private BookCarService bookCarService;

    @RequestMapping(value = "/findBookCarById")
    public JSONObject<BookCar> findBookCarById(@RequestBody BookCar bookCar){
        List<BookCar> carList = bookCarService.findBookCarById(bookCar.getUserId());
        JSONObject<BookCar> jsonObject = new JSONObject<>();
        if(carList.size()!=0){
            jsonObject.setList(carList);
            jsonObject.setCode(200);
            jsonObject.setMsg("数据查询成功!");
        }else {
            jsonObject.setCode(504);
            jsonObject.setMsg("数据查询失败!");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/countUserCar")
    public Integer countUserCar(String userId){
        return bookCarService.countUserCar(userId);
    }

    /**
     * @author: shenww
     * @description: 新增购物车中的书籍
     * @param: [bookCar]
     * @date: 2020/10/13
     * @return: com.sww.bank_book.utils.JSONObject<com.sww.bank_book.car.entity.BookCar>
     */
    @RequestMapping(value = "/addBook")
    public JSONObject<BookCar> addBook(BookCar bookCar){
        Integer addResult = bookCarService.addBook(bookCar);
        if(addResult == -1){
            return new JSONObject<>(null,null,-1,"数据有误!");
        }else{
            return new JSONObject<>(null,null,addResult,"successfully");
        }
    }

    /**
     * @author: shenww
     * @description: 减少购物车中的书籍
     * @param: [bookCar]
     * @date: 2020/10/13
     * @return: com.sww.bank_book.utils.JSONObject<com.sww.bank_book.car.entity.BookCar>
     */
    @RequestMapping(value = "/lessenBook")
    public JSONObject<BookCar> lessenBook(BookCar bookCar){
        Integer lessenResult = bookCarService.lessenBook(bookCar);
        if(lessenResult == -1){
            return new JSONObject<>(null,null,-1,"数据有误!");
        }else{
            return new JSONObject<>(null,null,lessenResult,"successfully");
        }
    }

    /**
     * @author: shenww
     * @description:删除购物车中的书籍
     * @param: [bookCarId]
     * @date: 2020/10/13
     * @return: com.sww.bank_book.utils.JSONObject<com.sww.bank_book.car.entity.BookCar>
     */
    @RequestMapping(value = "/deleteBook")
    public JSONObject<BookCar> deleteBook(String bookCarId){
        Integer deleteResult = bookCarService.deleteBook(bookCarId);
        if(deleteResult == -1){
            return new JSONObject<>(null,null,-1,"数据有误!");
        }else{
            return new JSONObject<>(null,null,deleteResult,"successfully");
        }
    }

    /**
     * @author: shenww
     * @description: 加入购物车
     * @param: [bookCar]
     * @date: 2020/10/13
     * @return: com.sww.bank_book.utils.JSONObject<com.sww.bank_book.car.entity.BookCar>
     */
    @RequestMapping(value = "/insertBuyBook")
    public JSONObject<BookCar> insertBuyBook(@RequestBody BookCar bookCar){
        Integer buyResult = bookCarService.insertBuyBook(bookCar);
        if(buyResult == -1){
            return new JSONObject<>(null,null,-1,"数据有误!");
        }else{
            return new JSONObject<>(null,null,buyResult,"successfully");
        }
    }

    /**
     * @author: shenww
     * @description: 查询加入购物车
     * @param: [bookCar]
     * @date: 2020/10/13
     * @return: com.sww.bank_book.utils.JSONObject<com.sww.bank_book.car.entity.BookCar>
     */
    @RequestMapping(value = "/buySearchBook")
    public JSONObject<BookCar> buySearchBook(BookCar bookCar){
        Integer buyResult = bookCarService.insertBuyBook(bookCar);
        if(buyResult == -1){
            return new JSONObject<>(null,null,-1,"数据有误!");
        }else{
            return new JSONObject<>(null,null,buyResult,"操作成功!");
        }
    }


}
