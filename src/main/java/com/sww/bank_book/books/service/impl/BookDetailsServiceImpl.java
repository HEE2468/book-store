package com.sww.bank_book.books.service.impl;

import com.sww.bank_book.books.dao.BookDetailsDao;
import com.sww.bank_book.books.entity.BookDetails;
import com.sww.bank_book.books.service.BookDetailsService;
import com.sww.bank_book.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
@Service
public class BookDetailsServiceImpl implements BookDetailsService {

    @Autowired
    private BookDetailsDao bookDetailsDao;

    @Override
    public Page findBookDetails(String bookCategoryId, String bookClassId, Integer currentPage) {

        // 设置每页显示8条数据
        int pageSize = 8;
        Page page = new Page();
        List<BookDetails> bookDetailsList = bookDetailsDao.findBookDetails(bookCategoryId,bookClassId,(currentPage-1)*pageSize,pageSize);
        Integer totalElements = bookDetailsDao.findBooksByIds(bookCategoryId,bookClassId);
        page.setTotalPages((int) Math.ceil((double) totalElements/pageSize));
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        page.setContent(bookDetailsList);
        page.setTotalElements(totalElements);
        return page;
    }

    @Override
    public BookDetails findBooksById(String bookDetailsId) {
        return bookDetailsDao.findBooksById(bookDetailsId);
    }

    /**
     * @author: shenww
     * @description: 书籍搜索
     * @param: [bookName]
     * @date: 2020/10/14
     * @return: java.util.List<com.sww.bank_book.books.entity.BookDetails>
     */
    @Override
    public Page findBooksDetailsLike(String bookName,Integer currentPage) {
        int pageSize = 8;
        Page page = new Page();
        List<BookDetails> bookDetailsList = bookDetailsDao.findBooksDetailsLike(bookName,(currentPage-1)*pageSize,pageSize);
        Integer count = bookDetailsDao.countBooksDetailsLike(bookName);
        page.setContent(bookDetailsList);
        page.setTotalElements(count);
        page.setTotalPages((int) Math.ceil((double) count/pageSize));
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        return page;
    }
}
