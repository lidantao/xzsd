package com.xzsd.app.goods.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/15中午10：29分
 * 功能：商品管理Service类
 */


import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.google.gson.Gson;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.utils.Response;
import net.sf.json.JSONString;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    public Response findGoods(String goodsCode) {
        System.out.println(goodsCode);
        GoodsInfo goodsInfo = goodsDao.findGoods(goodsCode);
        if (goodsInfo != null) {
            return Response.success("查询商品详情成功！", goodsInfo);
        } else {
            return Response.error("未查询到相关商品信息！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：31分
     * 功能：查询商品评价列表接口，GoodsInfo为商品实体类信息
     */
    public <T> Response listGoodsEvaluates(GoodsInfo goodsInfo) {
        //查询商品评价信息
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsEvaluates(goodsInfo);
        //查询商品评价图片
        List<GoodsInfo> imageList = goodsDao.ListEvaluateImage(goodsInfo);
        //new一个大list表，用户返回评论数据
        List<Map<String, T>> list = new ArrayList<>();
        if (goodsInfoList == null) {
            return Response.error("未查询到相关商品评价列表信息！");
        } else {
            for (GoodsInfo goodsInfo1 : goodsInfoList) {
                //new一个结果map集存放每一条用户评论数据
                Map<String, T> evaluateMap = new HashMap<>();
                evaluateMap.put("userAccount", (T) goodsInfo1.getUserAccount());
                evaluateMap.put("goodsEvaluateContent", (T) goodsInfo1.getGoodsEvaluateContent());
                evaluateMap.put("goodsEvaluateScore", (T) goodsInfo1.getGoodsEvaluateScore());
                evaluateMap.put("goodsEvaluateTime", (T) goodsInfo1.getGoodsEvaluateTime());
                //存放每个用户评论图片
                List<String> images = new ArrayList<>();
                for (GoodsInfo goodsInfo2 : imageList) {
                    if (goodsInfo2.getGoodsEvaluateCode().equals(goodsInfo1.getGoodsEvaluateCode())) {
                        images.add(goodsInfo2.getGoodsEvaluateImage());
                    }
                }
                //若无评价图片，传空值 ""
                if (images.size() == 0) {
                    evaluateMap.put("imaqgeList", null);
                } else {
                    evaluateMap.put("imageList", (T) images.toString());
                }
                list.add(evaluateMap);
            }
        }
        return Response.success("查询成功！", getPageInfo(list));
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：32分
     * 功能：查询一级商品分类列表接口
     */
    public Response listFirstGoodsCate() {
        List<GoodsInfo> goodsInfoList = goodsDao.firstListGoodsCate();
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到一级商品分类列表信息！");
        } else {
            return Response.success("查询成功！", goodsInfoList);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午：10：33分
     * 功能：查询二级商品分类以及商品接口，goodsCateCode为一级商品分类编号
     */
    public <T> Response listCateGoods(String goodsCateCode) {
        //查询全部二级商品分类
        List<GoodsInfo> cateList = goodsDao.secondListGoodsCate();
        //查询全部商品
        List<GoodsInfo> allGoods = goodsDao.listGoods();
        //存放返回给前端得list大列表数据
        List<Map<String, T>> list = new ArrayList<>();
        for (int i = 0; i < cateList.size(); i++) {
            //存放每一个商品分类的信息
            Map<String, T> map = new HashMap<>();
            map.put("goodsCateCode", (T) cateList.get(i).getGoodsCateCode());
            map.put("goodsCateName", (T) cateList.get(i).getGoodsCateName());
            //存放每一个商品分类下的商品信息
            List<GoodsInfo> goodsList = new ArrayList<>();
            for (int j = 0; j < allGoods.size(); j++) {
                if (allGoods.get(j).getSecondCateCode().equals(cateList.get(i).getGoodsCateCode())) {
                    goodsList.add(allGoods.get(j));
                }
            }
            //此商品分类下没有商品信息，则存null，有则返回数据
            if (goodsList.size() == 0) {
                map.put("goodsList", null);
            } else {
                map.put("goodsList", (T) goodsList);
            }
            list.add(map);
        }
        //没有任何商品分类信息，则返回未查询，有则返回list数据集
        if (list.size() == 0) {
            return Response.error("未查询到相关二级商品分类信息！");
        } else {
            return Response.success("查询成功！", list);
        }
    }

}
