package com.xzsd.app.goods.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/15中午10：29分
 * 功能：商品管理Service类
 */


import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;

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
     * 时间：2020/04/15中午10：29分
     * 功能：查询商品信息详情接口，goodsCode为商品编号
     */
    public Response findGoods(String goodsCode){
        GoodsInfo goodsInfo = goodsDao.findGoods(goodsCode);
        if (goodsInfo != null) {
            return Response.success("查询商品详情成功！", goodsInfo);
        } else {
            return Response.error("为查询到相关商品信息！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：31分
     * 功能：查询商品评价列表接口，GoodsInfo为商品实体类信息
     */
    public Response listGoodsEvaluates(GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsEvaluates(goodsInfo);
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到相关商品评价列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(goodsInfoList));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：32分
     * 功能：查询一级商品分类列表接口
     */
    public Response listFirstGoodsCate(){
        List<GoodsInfo> goodsInfoList = goodsDao.listFirstGoodsCate();
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到一级商品分类列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(goodsInfoList));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午：10：33分
     * 功能：查询二级商品分类以及商品接口，goodsCateCode为一级商品分类编号
     */
    public Response listCateGoods(String goodsCateCode){
        List<GoodsInfo> goodsInfoList = goodsDao.listCateGoods(goodsCateCode);
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到一级商品分类列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(goodsInfoList));
        }
    }
}
