package com.sww.bank_book.order.service;

import com.sww.bank_book.order.entity.BookOrder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
public interface BookOrderService {

    /**
     * 分页查找用户订单
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    List<BookOrder> findBookOrderById(String userId,int page,int limit);

    /**
     * 分页查找时，计算查出的总记录数
     * @param userId
     * @return
     */
    Integer findPageOrderById(String userId);

    /**
     * 批量插入订单
     * @param bookOrder
     * @return
     */
    Integer insertUserOrderBatch(BookOrder bookOrder);



}
