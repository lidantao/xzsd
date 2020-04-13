package com.xzsd.pc.goodsCate.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/12下午14：22分
 * 功能：商品分类Dao接口信息
 */


import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GoodsCateDao {


    //检查添加此商品分类名称是否存在
    int checkGoodsCate(GoodsCateInfo goodsCateInfo);


    //新增商品分类接口
    int addGoodsCate(GoodsCateInfo goodsCateInfo);

    //查询商品分类详情接口
    GoodsCateInfo findGoodsCate(String goodsCateCode);

    //查询商品分类列表接口
    List<GoodsCateInfo> firstlistGoodsCate();
    List<GoodsCateInfo> secondlistGoodsCate();

    //修改商品分类接口
    int updateGoodsCate(GoodsCateInfo goodsCateInfo);

    //删除商品分类接口
    int deleteGoodsCate(GoodsCateInfo goodsCateInfo);

}
