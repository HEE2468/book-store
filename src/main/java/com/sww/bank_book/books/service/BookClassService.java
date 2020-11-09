package com.sww.bank_book.books.service;

import com.sww.bank_book.books.entity.BookClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
public interface BookClassService {

    /**
     * 查找一级分类
     * @param bookCategoryId
     * @return
     */
    List<BookClass> findBookClass(String bookCategoryId);

    /**
     * 书籍一级分类从小到大排序，用于分页计算
     * @param bookCategoryId
     * @return
     */
    String findClassIdByOrder(String bookCategoryId);


}
