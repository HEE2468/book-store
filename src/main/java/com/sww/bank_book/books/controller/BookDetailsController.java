package com.sww.bank_book.books.controller;

import com.sww.bank_book.books.entity.BookDetails;
import com.sww.bank_book.books.service.BookDetailsService;
import com.sww.bank_book.utils.JSONObject;
import com.sww.bank_book.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
@RestController
@RequestMapping("/details")
public class BookDetailsController {

    @Autowired
    private BookDetailsService bookDetailsService;

    @RequestMapping(value = "/findBookDetails")
    public Page findBookDetails(@RequestBody Map<String,String> bookMap){
        return bookDetailsService.findBookDetails(bookMap.get("bookCategoryId"),bookMap.get("bookClassId"),Integer.valueOf(bookMap.get("currentPage")));
    }

    @RequestMapping(value = "/findBooksById")
    public BookDetails findBooksById(@RequestBody Map<String,String> bookMap){
        return bookDetailsService.findBooksById(bookMap.get("bookDetailsId"));
    }

    @RequestMapping(value = "/findBooksDetailsLike")
    public Page findBooksDetailsLike( String bookName,Integer currentPage){
        return bookDetailsService.findBooksDetailsLike(bookName,currentPage);

    }
}
