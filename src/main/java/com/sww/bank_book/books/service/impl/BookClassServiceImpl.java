package com.sww.bank_book.books.service.impl;

import com.sww.bank_book.books.dao.BookClassDao;
import com.sww.bank_book.books.entity.BookClass;
import com.sww.bank_book.books.service.BookClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
@Service
public class BookClassServiceImpl implements BookClassService {

    @Autowired
    private BookClassDao bookClassDao;

    @Override
    public List<BookClass> findBookClass(String bookCategoryId) {
        return bookClassDao.findBookClass(bookCategoryId);
    }


    @Override
    public String findClassIdByOrder(String bookCategoryId) {

        List<BookClass> bookClassList = bookClassDao.findClassIdByOrder(bookCategoryId);
        if(bookClassList.size() != 0){
            return bookClassList.get(0).getBookClassId();
        }
        return null;
    }
}
