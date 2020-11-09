package com.sww.bank_book.car.dao;

import com.sww.bank_book.car.entity.BookCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
@Mapper
@Component(value = "BookCarDao")
public interface BookCarDao {

    /**
     * 查找用户购物车中的所有未下单的书籍
     * @param userId
     * @return
     */
    List<BookCar> findBookCarById(@Param("userId") String userId);

    /**
     * 更新购物车的信息
     * @param bookCar
     * @return
     */
    Integer updateCarInfos(BookCar bookCar);

    /**
     * 统计用户购物车的数量
     * @param userId
     * @return
     */
    Integer countUserCar(@Param("userId") String userId);

    /**
     * 查找书籍的数量
     * @param bookCarId
     * @return
     */
    BookCar queryBookDetailsForCar(@Param("bookCarId") String bookCarId);

    /**
     * 更新书籍的数量
     * @param bookCar
     * @return
     */
    Integer updateBookDetailsForCar(BookCar bookCar);

    /**
     * 删除书籍
     * @param bookCarId
     * @return
     */
    Integer deleteBookDetailsForCar(@Param("bookCarId") String bookCarId);

    /**
     * 加入购物车
     * @param bookCar
     * @return
     */
    Integer insertBuyBook(BookCar bookCar);

    /**
     *  查找书籍在购物车中是否已存在
     * @param bookDetailsId
     * @return
     */
    BookCar findBookIsExit(@Param("userId") String userId,@Param("bookDetailsId") String bookDetailsId);
}
