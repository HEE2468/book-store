package com.sww.bank_book.books.dao;

import com.sww.bank_book.books.entity.BookClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
@Mapper
@Component(value = "BookClassDao")
public interface BookClassDao {

    /**
     * 查找一级分类
     * @param bookCategoryId
     * @return
     */
    List<BookClass> findBookClass(@Param("bookCategoryId") String bookCategoryId);

    /**
     * 书籍一级分类从小到大排序，用于分页计算
     * @param bookCategoryId
     * @return
     */
    List<BookClass> findClassIdByOrder(@Param("bookCategoryId") String bookCategoryId);

}
