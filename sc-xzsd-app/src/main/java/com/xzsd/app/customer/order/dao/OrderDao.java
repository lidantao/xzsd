package com.xzsd.app.customer.order.dao;

import com.xzsd.app.customer.order.entity.EvaluateInfo;
import com.xzsd.app.customer.order.entity.OrderDTO;
import com.xzsd.app.customer.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

@Mapper
public interface OrderDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查询商品编号
     */
    List<String> findGoodsCode(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查询商品购买数量
     */
    List<String> findGoodsCount(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新商品状态
     */
    int updateGoodsActice(List<Map> list);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新库存
     */
    int updateGoodsStock(OrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新销量
     */
    int updateSallNum(@Param("mapList") List<Map> mapList);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：删除对应购物车
     */
    int deleteShopCar(OrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查看商品库存，orderDao多参实体类，里面包含商品编号列表
     */
    List<String> findGoodsStock(OrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查看商品销量
     */
    List<String> findGoodsSallNum(@Param("goodsCodeList") List<String> goodsCodeList);

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
     * 功能：查询订单列表接口
     */
    List<OrderInfo> listOrderByPage(@Param("orderActive") String orderActive, @Param("currentUserCode") String currentUserCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<OrderInfo> findOrder(@Param("orderCode") String orderCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情列表接口
     */
    List<OrderInfo> listOrderDetail();

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
     int addGoodsEvaluate(@Param("evaluateListMap") List<Map> evaluateListMap);
    /**
     * 插入评价图片
     */
    int addGoodsEvaluateImage(@Param("evaluateImageListMap") List<Map> evaluateImageListMap);
    /**
     * 修改订单为已评价
     */
    int updateOrderEvaluateActive(OrderInfo orderInfo);
    /**
     * 查询各个商品平均星级
     */
    List<EvaluateInfo> findGoodsScore();
    /**
     * 更新产品的评价等级
     */
    int updateAvgGoodsScore(@Param("avgStarList") List<Map> avgStarList);


}
