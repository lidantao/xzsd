package com.xzsd.app.shopCar.dao;

import com.xzsd.app.shopCar.entity.ShopCarDTO;
import com.xzsd.app.shopCar.entity.ShopCarInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：37分
 * 功能：购物车Dao接口
 */

@Mapper
public interface ShopCarDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午16：49分
     * 功能：查询购物车是否存在此商品
     */
    int checkShopCar(ShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午16：49分
     * 功能：该商品存在购物车数量+1
     */
    int updateShopCarCount(ShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    int addShopCar(ShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    List<ShopCarInfo> listShopCarByPage();

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    int updateShopCar(ShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    int deleteShopCar(ShopCarDTO shopCarDTO);
}
