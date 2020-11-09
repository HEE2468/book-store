package com.sww.bank_book.books.entity;

import com.sww.bank_book.index.entity.BookCategory;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
public class BookDetails {

    private String bookDetailsId;
    private String bookCategoryId;
    private String bookClassId;
    private String bookName;
    private String image;
    private String bookTitle;
    private String bookDescription;
    private Double price;

    private BookCategory bookCategory;

    private BookClass bookClass;

    public String getBookDetailsId() {
        return bookDetailsId;
    }

    public void setBookDetailsId(String bookDetailsId) {
        this.bookDetailsId = bookDetailsId;
    }

    public String getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(String bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getBookClassId() {
        return bookClassId;
    }

    public void setBookClassId(String bookClassId) {
        this.bookClassId = bookClassId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public BookClass getBookClass() {
        return bookClass;
    }

    public void setBookClass(BookClass bookClass) {
        this.bookClass = bookClass;
    }
}
