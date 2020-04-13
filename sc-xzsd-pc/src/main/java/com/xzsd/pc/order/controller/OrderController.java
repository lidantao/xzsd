package com.xzsd.pc.order.controller;


import com.xzsd.pc.goodsCate.controller.GoodsCateController;
import com.xzsd.pc.goodsCate.service.GoodsCateService;
import com.xzsd.pc.order.entity.OrderDTO;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨00：39分
 * 功能：订单管理dao接口
 */


@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    //注入OrderService类
    @Resource
    private OrderService orderService;


    //查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
    @PostMapping("findOrder")
    public Response findOrder(OrderDTO orderDTO) {
        try {
            return orderService.findOrder(orderDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单详情有误！");
        }
    }


    //分页查询订单接口，orderInfo为订单实体类信息
    @PostMapping("listOrder")
    public Response listOrder(OrderInfo orderInfo) {
        try {
            return orderService.listOrder(orderInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询订单有误！");
        }
    }

    //修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
    @PostMapping("updateOrderActive")
    public Response updateOrderActive(OrderDTO orderDTO) {
        try {
            return orderService.updateOrderActive(orderDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改订单状态有误！");
        }
    }
}
