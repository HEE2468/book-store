package com.sww.bank_book.books.dao;

import com.sww.bank_book.books.entity.BookDetails;
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
@Component(value = "BookDetailsDao")
public interface BookDetailsDao {

    List<BookDetails> findBookDetails(@Param("bookCategoryId") String bookCategoryId, @Param("bookClassId") String bookClassId, @Param("offset") Integer offset, @Param("page") Integer page);

    Integer findBooksByIds(@Param("bookCategoryId") String bookCategoryId, @Param("bookClassId") String bookClassId);

    BookDetails findBooksById(@Param("bookDetailsId") String bookDetailsId);

    /**
     * 模糊查询
     * @param bookName
     * @return
     */
    List<BookDetails> findBooksDetailsLike(@Param("bookName") String bookName,@Param("offset") Integer offset, @Param("page") Integer page);

    /**
     * 计算页数
     * @param bookName
     * @return
     */
    Integer countBooksDetailsLike(@Param("bookName") String bookName);
}
