package com.xzsd.app.customer.order.entity;

import java.util.List;

public class EvaluateInfo {

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 评价等级
     */
    private String evaluateScore;

    /**
     * 评价图片序号
     */
    private String imageSortNum;

    /**
     * 评价图片路径
     */
    private String goodsEvaluateImage;

    /**
     * 平均星级
     */
    private Double avgScore;

    /**
     * 商品list
     */
    private List<EvaluateInfo> list;

    /**
     * 评价图片list
     */
    private List<EvaluateInfo> imageList;

    public List<EvaluateInfo> getImageList() {
        return imageList;
    }

    public void setImageList(List<EvaluateInfo> imageList) {
        this.imageList = imageList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getImageSortNum() {
        return imageSortNum;
    }

    public void setImageSortNum(String imageSortNum) {
        this.imageSortNum = imageSortNum;
    }


    public String getGoodsEvaluateImage() {
        return goodsEvaluateImage;
    }

    public void setGoodsEvaluateImage(String goodsEvaluateImage) {
        this.goodsEvaluateImage = goodsEvaluateImage;
    }

    public List<EvaluateInfo> getList() {
        return list;
    }

    public void setList(List<EvaluateInfo> list) {
        this.list = list;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }
}
