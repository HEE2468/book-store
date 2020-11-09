package com.sww.bank_book.order.controller;

import com.sww.bank_book.center.entity.UserManager;
import com.sww.bank_book.order.entity.BookOrder;
import com.sww.bank_book.order.service.BookOrderService;
import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
@RestController
@RequestMapping("/order")
public class BookOrderController {

    @Autowired
    private BookOrderService bookOrderService;

    @RequestMapping(value = "/findBookOrderById")
    public  Map<String, Object> findBookOrderById(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "userId", required = false) String userId){

        List<BookOrder> bookOrders = bookOrderService.findBookOrderById(userId,page,limit);
        Integer count = bookOrderService.findPageOrderById(userId);
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data",bookOrders);
        return resultMap;
    }

    @RequestMapping(value = "/insertUserOrderBatch")
    public Integer insertUserOrderBatch(@RequestBody BookOrder BookOrder){
        return bookOrderService.insertUserOrderBatch(BookOrder);
    }


}
