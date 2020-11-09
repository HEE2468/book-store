package com.sww.bank_book.order.service.impl;

import com.sww.bank_book.car.dao.BookCarDao;
import com.sww.bank_book.car.entity.BookCar;
import com.sww.bank_book.order.dao.BookOrderDao;
import com.sww.bank_book.order.entity.BookOrder;
import com.sww.bank_book.order.service.BookOrderService;
import com.sww.bank_book.utils.EntityIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private BookOrderDao bookOrderDao;

    @Autowired
    private BookCarDao bookCarDao;

    @Override
    public List<BookOrder> findBookOrderById(String userId,int page,int limit) {
        if(userId!=null){
            return bookOrderDao.findBookOrderById(userId,(page-1)*limit,limit);
        }else {
            // 未登录
            return null;
        }
    }

    @Override
    public Integer findPageOrderById(String userId) {
        return bookOrderDao.findPageOrderById(userId);
    }

    /**
     * 批量提交订单
     * @param bookOrder
     * @return
     */
    @Override
    public Integer insertUserOrderBatch(BookOrder bookOrder) {

        // 查询用户的购物车
        List<BookCar> bookCarList = bookCarDao.findBookCarById(bookOrder.getUserId());
        List<BookOrder> bookOrderList = new ArrayList<>();
        if(bookCarList.size()!=0){

            for(BookCar car:bookCarList){
                BookOrder order = new BookOrder();
                order.setBookOrderId(EntityIDFactory.createId());
                order.setUserId(bookOrder.getUserId());
                order.setBookDetailsId(car.getBookDetailsId());

                if(!"".equals(car.getNumber())){
                    order.setOrderNumber(car.getNumber());
                }
                order.setOrderDate(new Date());
                order.setPayType(bookOrder.getPayType());

                if(!"".equals(car.getPrice()) && !"".equals(car.getNumber())){
                    order.setAmount(car.getNumber()*car.getPrice());
                }

                bookOrderList.add(order);

                // 更改购物车中对应书籍的状态
                car.setHasOrder(1);
                Integer carNum = bookCarDao.updateCarInfos(car);
                if(carNum <=0){
                    return -1;
                }
            }

            // 更新用户地址
            BookOrder od = new BookOrder();
            od.setUserId(bookOrder.getUserId());
            od.setDeliveryName(bookOrder.getDeliveryName());
            od.setTelephone(bookOrder.getTelephone());
            od.setAddress(bookOrder.getAddress());
            bookOrderDao.updateUserAddress(od);

            // 批量插入订单信息
            return bookOrderDao.insertUserOrderBatch(bookOrderList);
        }else{
            // 订单信息提交有误
            return -1;
        }
    }


}
