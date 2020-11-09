package com.sww.bank_book.order.dao;

import com.sww.bank_book.order.entity.BookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
@Mapper
@Component(value = "BookOrderDao")
public interface BookOrderDao {

    List<BookOrder> findBookOrderById(@Param("userId") String userId,@Param("page") int page,@Param("limit") int limit);

    Integer findPageOrderById(@Param("userId") String userId);

    Integer insertUserOrderBatch(List<BookOrder> list);

    /**
     * 更新用户的收货地址
     * @param bookOrder
     * @return
     */
    Integer updateUserAddress(BookOrder bookOrder);
}
