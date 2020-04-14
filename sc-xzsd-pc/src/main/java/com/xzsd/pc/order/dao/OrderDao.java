package com.xzsd.pc.order.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨00：39分
 * 功能：订单管理dao接口
 */

import com.xzsd.pc.order.entity.OrderDTO;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     */
    List<OrderInfo> findOrder(OrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：分页查询订单接口，orderInfo为订单实体类信息
     */
    List<OrderInfo> listOrderByPage(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
     */
    int updateOrderActive(OrderDTO orderDTO);

}
