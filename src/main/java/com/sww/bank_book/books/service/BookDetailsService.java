package com.sww.bank_book.books.service;

import com.sww.bank_book.books.entity.BookDetails;
import com.sww.bank_book.utils.Page;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
public interface BookDetailsService {

    Page findBookDetails(String bookCategoryId, String bookClassId, Integer currentPage);

    BookDetails findBooksById(String bookDetailsId);

    Page findBooksDetailsLike(String bookName,Integer currentPage);
}
