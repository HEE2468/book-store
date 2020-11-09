package com.sww.bank_book.index.entity;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */
public class BookCategory {

    private String book_category_id;
    private String category;
    private String img;

    public String getBook_category_id() {
        return book_category_id;
    }

    public void setBook_category_id(String book_category_id) {
        this.book_category_id = book_category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
