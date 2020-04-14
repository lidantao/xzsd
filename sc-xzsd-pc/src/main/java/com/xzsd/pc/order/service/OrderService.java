package com.xzsd.pc.order.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨00：39分
 * 功能：订单管理dao接口
 */


import com.alibaba.fastjson.JSON;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsCate.dao.GoodsCateDao;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDTO;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderService {

    //注入OrderDao类
    @Resource
    private OrderDao orderDao;


//    /**
//     * 作者：李丹涛
//     * 时间：2020/04/14下午15：01分
//     * 支付状态
//     * NOPAY:0未支付
//     * ISPAY:1支付
//     */
//    private static final String NOPAY = "0";
//    private static final String ISPAY = "1";


    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     */
    public Response findOrder(OrderDTO orderDTO) {
        System.out.println(JSON.toJSONString(orderDTO));
        List<OrderInfo> list = orderDao.findOrder(orderDTO);
        if (list.size() == 0) {
            return Response.error("未查询到相关订单信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(list));
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：分页查询订单接口，orderInfo为订单实体类信息
     */
    public Response listOrder(OrderInfo orderInfo) {
        List<OrderInfo> list = orderDao.listOrderByPage(orderInfo);
        if (list.size() == 0) {
            return Response.error("未查询到订单列表相关信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(list));
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateOrderActive(OrderDTO orderDTO) {
        //设置当前修改者编码
        orderDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = orderDao.updateOrderActive(orderDTO);
        if (count > 0) {
            return Response.success("修改订单状态成功！");
        } else {
            return Response.error("修改信息有误！");
        }
    }

}
