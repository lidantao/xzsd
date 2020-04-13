package com.xzsd.pc.hotGoods.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品管理dao接口
 */


import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import com.xzsd.pc.hotGoods.entity.HotGoodsDTO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotGoodsDao {


    //检查添加此热门商品或排序是否存在
    int checkHotGoods(HotGoodsInfo hotGoodsInfo);

    //新增热门商品接口,hotGoodsInfo是热门商品实体类信息
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    //查询热门商品详情接口,hotGoodsInfo是热门商品实体类信息
    HotGoodsInfo findHotGoods(String hotGoodsCode);

    //分页查询热门商品接口,hotGoodsInfo是热门商品实体类信息
    List<HotGoodsInfo> listHotGoodsByPage(HotGoodsInfo hotGoodsInfo);

    //修改热门商品接口,hotGoodsInfo是热门商品实体类信息
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    //查询热门商品展示数量接口
    HotGoodsInfo findHotGoodsShowNum();

    //修改热门商品数量展示接口,hotGoodsInfo是热门商品实体类信息
    int updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo);

    //删除热门商品接口,hotGoodsDTO是前端传递多参数接收的实体类信息
    int deleteHotGoods(HotGoodsDTO hotGoodsDTO);
}
