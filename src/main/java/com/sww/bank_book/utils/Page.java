package com.sww.bank_book.utils;

import java.util.List;

/**
 * @author HEE
 * @date 2020/10/10
 * @description
 */
public class Page {

    private Integer currentPage; //当前显示第几页数据
    private Integer pageSize; //每一页显示多少条数据
    private Integer totalPages; //总页数
    private Integer totalElements; //总记录数
    private List content;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
