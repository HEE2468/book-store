package com.sww.bank_book.car.entity;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
public class BookCar {

    private String bookCarId;
    private String userId;
    private String bookDetailsId;
    private Integer number;
    private String bookName;
    private Double price;
    private String image;
    private Integer hasOrder;

    public BookCar(){}

    public BookCar(String bookCarId, Integer number) {
        this.bookCarId = bookCarId;
        this.number = number;
    }

    public String getBookCarId() {
        return bookCarId;
    }

    public void setBookCarId(String bookCarId) {
        this.bookCarId = bookCarId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookDetailsId() {
        return bookDetailsId;
    }

    public void setBookDetailsId(String bookDetailsId) {
        this.bookDetailsId = bookDetailsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getHasOrder() {
        return hasOrder;
    }

    public void setHasOrder(Integer hasOrder) {
        this.hasOrder = hasOrder;
    }
}
