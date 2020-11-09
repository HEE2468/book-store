package com.sww.bank_book.car.service.impl;

import com.sww.bank_book.car.dao.BookCarDao;
import com.sww.bank_book.car.entity.BookCar;
import com.sww.bank_book.car.service.BookCarService;
import com.sww.bank_book.utils.EntityIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
@Service
public class BookCarServiceImpl implements BookCarService {

    @Autowired
    private BookCarDao bookCarDao;

    @Override
    public List<BookCar> findBookCarById(String userId) {
        return bookCarDao.findBookCarById(userId);
    }

    @Override
    public Integer countUserCar(String userId) {
        return bookCarDao.countUserCar(userId);
    }

    @Override
    public Integer addBook(BookCar bookCar) {
        if(bookCar.getBookCarId() != null){
            BookCar car = bookCarDao.queryBookDetailsForCar(bookCar.getBookCarId());
            if(car == null){
                // 数据有误
                return -1;
            }else{
                System.out.println("id :" +car.getBookCarId());
                car.setNumber(car.getNumber() + 1);
                Integer updateNum = bookCarDao.updateBookDetailsForCar(car);
                if(updateNum<=0){
                    // 数据有误
                    return -1;
                }
                return updateNum;
            }

        }else{
            // 数据有误
            return -1;
        }
    }

    @Override
    public Integer lessenBook(BookCar bookCar) {
        if(bookCar.getBookCarId() != null){
            BookCar car = bookCarDao.queryBookDetailsForCar(bookCar.getBookCarId());
            if(car == null){
                // 数据有误
                return -1;
            }else{
                car.setNumber(car.getNumber() - 1);
                Integer updateNum = bookCarDao.updateBookDetailsForCar(car);
                if(updateNum<=0){
                    // 数据有误
                    return -1;
                }
                return updateNum;
            }

        }else{
            // 数据有误
            return -1;
        }
    }

    @Override
    public Integer deleteBook(String bookCarId) {
        if("".equals(bookCarId)){
           return -1;
        }
        return bookCarDao.deleteBookDetailsForCar(bookCarId);
    }

    @Override
    public Integer insertBuyBook(BookCar bookCar) {
        if(bookCar.getUserId() == null || bookCar.getBookDetailsId() == null){
            // 数据有误
            return -1;
        }

        // 该书籍已存在购物车中，更新原购物车中书籍的数量
        BookCar car = bookCarDao.findBookIsExit(bookCar.getUserId(),bookCar.getBookDetailsId());
        if(car != null){
            car.setNumber(car.getNumber() + 1);
            Integer updateNum = bookCarDao.updateBookDetailsForCar(car);
            if(updateNum<=0){
                // 数据有误
                return -1;
            }
            return 1;
        }

        bookCar.setBookCarId(EntityIDFactory.createId());
        bookCar.setHasOrder(0);
        bookCar.setNumber(1);
        return bookCarDao.insertBuyBook(bookCar);
    }
}
