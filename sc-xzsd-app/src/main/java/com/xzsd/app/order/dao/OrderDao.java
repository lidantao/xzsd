package com.xzsd.app.order.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */


import com.xzsd.app.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     */
    int addOrder(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单详情接口
     */
    int addOrderDetail(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：删除购物车
     */
    int deleteShopCar(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<OrderInfo> listOrderByPage(@Param("orderActive") String orderActive, @Param("currentUserCode") String currentUserCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<OrderInfo> listOrderByPage(@Param("orderCode") String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情列表接口
     */
    List<OrderInfo> listOrderDetailByPage();

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    int updateOrderActive(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    List<OrderInfo> orderDetail();

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    List<OrderInfo> listGoodsForEvaluate(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单商品评价接口
     */
    /**
     * 插入评价内容
     */
     int addGoodsEvaluate(List<Map> evaluateListMap);
    /**
     * 插入评价图片
     */
    int addGoodsEvaluateImage(List<Map> evaluateImageListMap);

}
