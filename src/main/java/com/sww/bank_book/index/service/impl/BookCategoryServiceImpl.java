package com.sww.bank_book.index.service.impl;

import com.sww.bank_book.index.dao.BookCategoryDao;
import com.sww.bank_book.index.entity.BookCategory;
import com.sww.bank_book.index.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public List<BookCategory> findBookCategory() {
        return bookCategoryDao.findBookCategory();
    }
}
