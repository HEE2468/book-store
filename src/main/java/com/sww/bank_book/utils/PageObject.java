package com.sww.bank_book.utils;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
public class PageObject<T> {

    private List<T> msg;

    public List<T> getMsg() {
        return msg;
    }

    public void setMsg(List<T> msg) {
        this.msg = msg;
    }

    public PageObject() {

    }

    public PageObject(List<T> msg) {
        this.msg = msg;
    }
}
