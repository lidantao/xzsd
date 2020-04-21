package com.xzsd.app.order.controller;

import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    //注入orderService类
    @Resource
    private OrderService orderService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     */
    @PostMapping("addOrder")
    public Response addOrder(String goodsCode, String goodsCount, String goodsSumPrice, String storeCode){
        try {
            return orderService.addOrder(goodsCode, goodsCount, goodsSumPrice, storeCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增订单操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    @PostMapping("listOrder")
    public Response listOrder(String orderActive){
        try {
            return orderService.listOrder(orderActive);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    @PostMapping("updateOrderActive")
    public Response updateOrderActive(OrderInfo orderInfo){
        try {
            return orderService.updateOrderActive(orderInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改订单状态操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    @PostMapping("orderDetail")
    public Response orderDetail(String orderCode){
        try {
            return orderService.orderDetail(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单详情操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    @PostMapping("listGoodsForEvaluate")
    public Response listGoodsForEvaluate(String orderCode){
        try {
            return orderService.listGoodsForEvaluate(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单评价商品信息列表有误！");
        }
    }
}
