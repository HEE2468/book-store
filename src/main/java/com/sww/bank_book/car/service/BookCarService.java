package com.sww.bank_book.car.service;

import com.sww.bank_book.car.entity.BookCar;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
public interface BookCarService {

    List<BookCar> findBookCarById(String userId);

    Integer countUserCar(String userId);

    Integer addBook(BookCar bookCar);

    Integer lessenBook(BookCar bookCar);

    Integer deleteBook(String bookCarId);

    Integer insertBuyBook(BookCar bookCar);
}
