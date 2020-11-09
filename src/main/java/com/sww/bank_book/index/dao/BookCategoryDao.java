package com.sww.bank_book.index.dao;

import com.sww.bank_book.index.entity.BookCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */

@Mapper
@Component(value = "BookCategoryDao")
public interface BookCategoryDao {

    List<BookCategory> findBookCategory();
}
