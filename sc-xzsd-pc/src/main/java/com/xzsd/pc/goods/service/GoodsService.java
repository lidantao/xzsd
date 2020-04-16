package com.xzsd.pc.goods.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/11晚上19：52
 * 功能：商品管理GoodsService类
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsCateInfo;
import com.xzsd.pc.goods.entity.GoodsDTO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class GoodsService {


    //注入GoodsDao接口
    @Resource
    private GoodsDao goodsDao;


    /**
     * 作者：李丹涛
     * 商品状态（
     * SALLING:在售1、
     * DOWN:已下架2、
     * NOUP:未发布3
     */
    private static final String SALLING = "1";
    private static final String DOWN = "2";
    private static final String NOUP = "3";

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品分类下拉框接口，goodsCateInfo为商品分类实体类信息
     */
    public Response listGoodsCate(GoodsCateInfo goodsCateInfo) {
        List<GoodsCateInfo> goodsCateInfoList = goodsDao.listGoodsCate(goodsCateInfo);
        if (goodsCateInfoList.size() > 0) {
            return Response.success("查询商品分类下拉框信息成功！", goodsCateInfoList);
        } else {
            return Response.error("未查询到相关商品分类信息！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：新增商品接口，goodsInfo商品信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addGoods(GoodsInfo goodsInfo) {
        //设置随机isbn
        goodsInfo.setIsbn(String.valueOf(((int) ((Math.random() * 9 + 1) * 100000))));
        //设置创建者和修改者
        goodsInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        goodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //随机生成商品编号,返回数据:时间戳+3为随机数
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        goodsInfo.setIsDelete("0");
        int count = goodsDao.addGoods(goodsInfo);
        if (count > 0) {
            return Response.success("新增商品信息成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增信息有误，请重新填写！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品详情接口，goodsCode商品编号
     */
    public Response findGoods(String goodsCode) {
        GoodsInfo goodsInfo = goodsDao.findGoods(goodsCode);
        if (goodsInfo != null) {
            return Response.success("查询商品详情成功！", goodsInfo);
        } else {
            return Response.error("未查询到相关商品信息！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：分页查询商品列表接口，goodsInfo商品信息
     */
    public Response listGoods(GoodsInfo goodsInfo) {
        if (goodsInfo.getGoodsActive() == null || goodsInfo.getGoodsActive() == "") {
            goodsInfo.setGoodsActive(SALLING);
        }
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        System.out.println(goodsInfoList);
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到相关商品列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(goodsInfoList));
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品接口，goodsInfo商品信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateGoods(GoodsInfo goodsInfo) {
        //设置当前修改者编码
        goodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = goodsDao.updateGoods(goodsInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改商品信息操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：删除商品接口，goodsDTO用户form传的参数
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteGoods(GoodsDTO goodsDTO) {
        goodsDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //删除商品、同时删除热门商品、轮播图
        int delete1 = goodsDao.deleteHotGoods(goodsDTO);
        int delete2 = goodsDao.deleteGoods(goodsDTO);
        int delete3 = goodsDao.deleteRotateGoods(goodsDTO);
        if (delete1 > 0 && delete2 > 0 && delete3 > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除商品操作有误！");
        }
    }

}
