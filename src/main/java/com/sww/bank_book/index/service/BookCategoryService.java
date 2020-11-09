package com.sww.bank_book.index.service;

import com.sww.bank_book.index.entity.BookCategory;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */
public interface BookCategoryService {

    List<BookCategory> findBookCategory();
}
