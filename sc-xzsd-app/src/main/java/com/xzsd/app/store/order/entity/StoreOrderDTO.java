package com.xzsd.app.store.order.entity;


/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：45分
 * 功能：多参传递dto实体类
 */
public class StoreOrderDTO {

    /**
     * 订单状态
     */
    private String orderActive;

    /**
     * 页码
     */
    private int PageNum;

    /**
     * 页数量
     */
    private int PageSize;

    /**
     * 总数量
     */
    private int total;


    public String getOrderActive() {
        return orderActive;
    }

    public void setOrderActive(String orderActive) {
        this.orderActive = orderActive;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
