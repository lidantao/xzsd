package com.xzsd.pc.goods.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/11晚上19：52
 * 功能：商品管理GoodsDao类
 */


import com.xzsd.pc.goods.entity.GoodsCateInfo;
import com.xzsd.pc.goods.entity.GoodsDTO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GoodsDao {

    //查询商品分类下拉框接口
    List<GoodsCateInfo> listGoodsCate(GoodsCateInfo goodsCateInfo);

    //新增商品接口
    int addGoods(GoodsInfo goodsInfo);

    //查询商品详情接口
    GoodsInfo findGoods(String goodsCode);

    //分页查询商品列表接口
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    //修改商品接口
    int updateGoods(GoodsInfo goodsInfo);

    //删除商品接口
    int deleteGoods(GoodsDTO goodsDTO);

}
