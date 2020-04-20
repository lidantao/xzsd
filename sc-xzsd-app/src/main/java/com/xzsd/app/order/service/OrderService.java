package com.xzsd.app.order.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

import com.alibaba.fastjson.JSONObject;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderService {

    //注入OrderDao接口
    @Resource
    private OrderDao orderDao;

    /**
     * 支付状态,已支付
     */
    private static final String PAYACTIVE = "0";

    /**
     * 订单状态编号：0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价
     */
    private static final String ORDERACTIVE = "0";

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addOrder(String goodsCode, String goodsCount, String goodsSumPrice, String storeCode){
        //分割成列表
        OrderInfo orderInfo = new OrderInfo();
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        List<String> goodsCountList = Arrays.asList(goodsCount.split(","));
        List<String> goodsSumPriceList = Arrays.asList(goodsSumPrice.split(","));
        //随机生成订单编号,返回数据:时间戳+3为随机数
        orderInfo.setOrderCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        orderInfo.setIsDelete("0");
        //商品总数量 pucharNum
        int pucharNum = 0;
        //商品总价格
        double sumPrice = 0.0;
        //设置创建者和修改者和登录者
        String createUser = SecurityUtils.getCurrentUserId();
        String lastUpdateUser = createUser;
        String userCode = createUser;
        //对其属性
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < goodsCodeList.size(); i++) {
            //new一个小map将其对应属性收集起来
            Map map = new HashMap<>();
            //随机生成订单详情编号,返回数据:时间戳+3为随机数
            String orderDetailCode = StringUtil.getCommonCode(3);
            map.put("orderDetailCode",orderDetailCode);
            map.put("goodsCode",goodsCodeList.get(i));
            map.put("goodsCount",goodsCountList.get(i));
            map.put("goodsSumPrice",goodsSumPriceList.get(i));
            map.put("createUser",createUser);
            map.put("lastUpdateUser",lastUpdateUser);
            map.put("userCode",userCode);
            map.put("orderCode",orderInfo.getOrderCode());
            pucharNum += Integer.parseInt(goodsCountList.get(i));
            sumPrice += Double.parseDouble(goodsSumPriceList.get(i));
            mapList.add(map);
        }
        orderInfo.setMapList(mapList);
        orderInfo.setPucharNum(pucharNum);
        orderInfo.setSumPrice(sumPrice);
        //设置门店编号
        orderInfo.setStoreCode(storeCode);
        //设置支付状态
        orderInfo.setPayActive(PAYACTIVE);
        //设置订单状态
        orderInfo.setOrderActive(ORDERACTIVE);
        //设置创建者和修改者和登录者
        orderInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        orderInfo.setUserCode(SecurityUtils.getCurrentUserId());
        //添加到订单表
        int add1 = orderDao.addOrder(orderInfo);
        //添加到订单详情
        int add2 = orderDao.addOrderDetail(orderInfo);
        //删除购物车商品
        orderInfo.setGoodsCodeList(goodsCodeList);
        orderDao.deleteShopCar(orderInfo);
        if (add1 > 0 && add2 > 0) {
            return Response.success("新增订单成功！");
        }else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("添加订单操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    public Response listOrder(String orderActive){
        //获取当前登录者
        String currentUserCode = SecurityUtils.getCurrentUserId();
        //String currentUserCode = "20200418120445534796";
        //查询订单列表
        List<OrderInfo> orderInfoList = orderDao.listOrderByPage(orderActive,currentUserCode);
        //查询订单详情列表
        List<OrderInfo> orderInfoDetailList = orderDao.listOrderDetailByPage();
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < orderInfoList.size(); i++) {
            Map map = new HashMap();
            map.put("orderCode",orderInfoList.get(i).getOrderCode());
            map.put("orderActive",orderInfoList.get(i).getOrderActive());
            map.put("sumPrice",orderInfoList.get(i).getSumPrice());
            map.put("pucharNum",orderInfoList.get(i).getPucharNum());
            map.put("version",orderInfoList.get(i).getVersion());
            List<Map> list = new ArrayList<>();
            Map map1 = new HashMap();
            for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
                if(orderInfoDetailList.get(i1).getOrderCode().equals(orderInfoList.get(i).getOrderCode())){
                    map1.put("goodsName",orderInfoDetailList.get(i1).getGoodsName());
                    map1.put("goodsImagePath",orderInfoDetailList.get(i1).getGoodsImagePath());
                    map1.put("goodsIntroduce",orderInfoDetailList.get(i1).getGoodsIntroduce());
                    map1.put("goodsPrice",orderInfoDetailList.get(i1).getGoodsPrice());
                    map1.put("goodsCount",orderInfoDetailList.get(i1).getGoodsCount());
                    map1.put("goodsCode",orderInfoDetailList.get(i1).getGoodsCode());
                    list.add(map1);
                }
            }
            map.put("goodsList",list);
            mapList.add(map);
        }
        if(mapList.size()==0){
            return Response.error("未查询到相关列表订单信息!");
        }else {
            return Response.success("查询成功!",getPageInfo(mapList));
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateOrderActive(OrderInfo orderInfo){
        //设置当前修改者编码
        orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = orderDao.updateOrderActive(orderInfo);
        if (count > 0) {
            return Response.success("修改订单状态成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的修改订单状态信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    public Response orderDetail(String orderCode){
        //获取当前登录者
        String currentUserCode = SecurityUtils.getCurrentUserId();
        //String currentUserCode = "20200418120445534796";
        //查询订单列表
        List<OrderInfo> orderInfoList = orderDao.listOrderByPage(orderCode,currentUserCode);
        //查询订单详情列表
        List<OrderInfo> orderInfoDetailList = orderDao.listOrderDetailByPage();
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < orderInfoList.size(); i++) {
            Map map = new HashMap();
            map.put("storeName",orderInfoList.get(i).getStoreName());
            String address = orderInfoList.get(i).getProvinceName()
                    + orderInfoList.get(i).getCityName()
                    + orderInfoList.get(i).getAreaName()
                    + orderInfoList.get(i).getAddress();
            map.put("address",address);
            map.put("orderCode",orderInfoList.get(i).getOrderCode());
            map.put("orderActive",orderInfoList.get(i).getOrderActive());
            map.put("sumPrice",orderInfoList.get(i).getSumPrice());
            map.put("payTime",orderInfoList.get(i).getPayTime());
            map.put("pucharNum",orderInfoList.get(i).getPucharNum());
            map.put("version",orderInfoList.get(i).getVersion());
            List<Map> list = new ArrayList<>();
            Map map1 = new HashMap();
            for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
                if(orderInfoDetailList.get(i1).getOrderCode().equals(orderInfoList.get(i).getOrderCode())){
                    map1.put("goodsName",orderInfoDetailList.get(i1).getGoodsName());
                    map1.put("goodsImagePath",orderInfoDetailList.get(i1).getGoodsImagePath());
                    map1.put("goodsIntroduce",orderInfoDetailList.get(i1).getGoodsIntroduce());
                    map1.put("goodsPrice",orderInfoDetailList.get(i1).getGoodsPrice());
                    map1.put("goodsCount",orderInfoDetailList.get(i1).getGoodsCount());
                    map1.put("goodsCode",orderInfoDetailList.get(i1).getGoodsCode());
                    list.add(map1);
                }
            }
            map.put("goodsList",list);
            mapList.add(map);
        }
        if(mapList.size()==0){
            return Response.error("未查询到相关订单详情信息!");
        }else {
            return Response.success("查询成功!",mapList);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    public Response listGoodsForEvaluate(String orderCode){
        //获取当前登录者
        //String currentUserCode = SecurityUtils.getCurrentUserId();
        //测试用，设置当前userCode
        String currentUserCode = "20200418120445534796";
        //查询订单详情列表
        List<OrderInfo> orderInfoDetailList = orderDao.listOrderDetailByPage();
        List<Map> list = new ArrayList<>();
        Map map1 = new HashMap();
        for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
            if(orderInfoDetailList.get(i1).getOrderCode().equals(orderCode)){
                map1.put("goodsImagePath",orderInfoDetailList.get(i1).getGoodsImagePath());
                map1.put("goodsCode",orderInfoDetailList.get(i1).getGoodsCode());
                list.add(map1);
            }
        }
        if(list.size()==0){
            return Response.error("未查询到订单评价商品信息!");
        }else {
            return Response.success("查询成功!",list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单商品评价接口
     */
    public Response addGoodsEvaluate(String obj){
        JSONObject json = JSONObject.parseObject(obj);
        String orderCode = json.getString("orderCode");
        String list = json.getString("list");
        //new一个插入订单评价的List
        List<Map> evaluateListMap = new ArrayList<>();
        //new一个插入评价图片表的List
        List<Map> evaluateImageListMap = new ArrayList<>();
        //获取list长度
        List<String> evaluateList = Arrays.asList(list);
        for (int i = 0; i < evaluateList.size(); i++) {
            //new一个小map存单个评价
            Map map = new HashMap();
            //new一个小map存单个图片
            Map map1 = new HashMap();
            //列表转json
            JSONObject json1 = JSONObject.parseObject(evaluateList.get(i));
            String imageList = json1.getString("imageList");
            //提取json中的评价图片列表
            JSONObject json2 = JSONObject.parseObject(imageList);
            String goodsCode = json1.getString("goodsCode");
            String evaluateContent = json1.getString("evaluateContent");
            String evaluateScore = json1.getString("evaluateScore");
            String imageSortNum = json2.getString("imageSortNum");
            String goodsImagePath = json2.getString("goodsImagePath");
            String evaluateCode = StringUtil.getCommonCode(3);
            map.put("evaluateCode",evaluateCode);
            map.put("goodseEaluateScore",evaluateScore);
            map.put("goodsEvaluateContent",evaluateContent);
            map.put("goodsCode",goodsCode);
            map.put("createUser",SecurityUtils.getCurrentUserId());
            map.put("lastUpdateUser",SecurityUtils.getCurrentUserId());
            map.put("goodsEvaluateUser",SecurityUtils.getCurrentUserId());
            evaluateListMap.add(map);
            map1.put("evaluateImageCode",StringUtil.getCommonCode(3));
            map1.put("evaluateCode",evaluateCode);
            map1.put("goodsImagePath",goodsImagePath);
            map1.put("imageSortNum",imageSortNum);
            map1.put("createUser",SecurityUtils.getCurrentUserId());
            map1.put("lastUpdateUser",SecurityUtils.getCurrentUserId());
            evaluateImageListMap.add(map1);
        }
        //插入评价表
        int add1 = orderDao.addGoodsEvaluate(evaluateListMap);
        //插入评价图片
        int add2 = orderDao.addGoodsEvaluateImage(evaluateImageListMap);
        if(add1 > 0 && add2 > 0){
            return Response.success("评价成功！");
        }else {
            return Response.error("评价信息有误！");
        }
    }
}
