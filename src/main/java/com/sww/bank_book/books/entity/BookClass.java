package com.sww.bank_book.books.entity;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
public class BookClass {

    private String bookClassId;
    private String bookCategoryId;
    private String classes;

    public String getBookClassId() {
        return bookClassId;
    }

    public void setBookClassId(String bookClassId) {
        this.bookClassId = bookClassId;
    }

    public String getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(String bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
