package com.sww.bank_book.order.entity;

import com.sww.bank_book.books.entity.BookDetails;
import com.sww.bank_book.center.entity.UserManager;
import com.sww.bank_book.login.entity.User;

import java.util.Date;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
public class BookOrder {

    private String bookOrderId;
    private String userId;
    private String bookDetailsId;
    private Integer orderNumber;
    private Integer orderType;
    private Integer payType;
    private Date orderDate;
    private Double amount;
    private String bookName;
    private String bookDescription;
    private String bookDetailsImg;
    private String deliveryName;
    private String telephone;
    private String address;
    private Double price;

    public BookOrder(){}

    public BookOrder(String bookOrderId, String userId, String bookDetailsId, Integer orderNumber, Integer orderType, Integer payType, Date orderDate, Double amount, String bookName, String bookDescription, String bookDetailsImg, String deliveryName, String telephone, String address, Double price) {
        this.bookOrderId = bookOrderId;
        this.userId = userId;
        this.bookDetailsId = bookDetailsId;
        this.orderNumber = orderNumber;
        this.orderType = orderType;
        this.payType = payType;
        this.orderDate = orderDate;
        this.amount = amount;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookDetailsImg = bookDetailsImg;
        this.deliveryName = deliveryName;
        this.telephone = telephone;
        this.address = address;
        this.price = price;
    }

    public String getBookOrderId() {
        return bookOrderId;
    }

    public void setBookOrderId(String bookOrderId) {
        this.bookOrderId = bookOrderId;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookDetailsImg() {
        return bookDetailsImg;
    }

    public void setBookDetailsImg(String bookDetailsImg) {
        this.bookDetailsImg = bookDetailsImg;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
