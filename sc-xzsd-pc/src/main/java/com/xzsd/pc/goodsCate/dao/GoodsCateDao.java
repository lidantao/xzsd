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


    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：检查添加此商品分类名称是否存在，goodsCateInfo为商品分类实体类信息
     */
    int checkGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：新增商品分类接口,goodsCateInfo商品管理实体类信息
     */
    int addGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类详情接口，goodsCateCode为热门商品编号
     */
    GoodsCateInfo findGoodsCate(String goodsCateCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类列表接口
     */
    List<GoodsCateInfo> firstlistGoodsCate();
    List<GoodsCateInfo> secondlistGoodsCate();

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：修改商品分类接口，goodsCateInfo商品分类信息
     */
    int updateGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：删除商品分类接口，goodsCateInfo为商品分类实体类信息
     */
    int deleteGoodsCate(GoodsCateInfo goodsCateInfo);

}
