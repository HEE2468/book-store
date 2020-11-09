package com.sww.bank_book.utils;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/9
 * @description
 */
public class JSONObject<T> {

    private List<T> list;
    private T data;
    private Integer code;
    private String msg;



    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject(){}

    public JSONObject(List<T> list, T data, Integer code, String msg) {
        this.list = list;
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public JSONObject(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
