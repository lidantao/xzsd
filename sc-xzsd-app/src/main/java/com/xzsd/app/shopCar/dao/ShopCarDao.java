package com.xzsd.app.shopCar.dao;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：37分
 * 功能：购物车Dao接口
 */

import com.xzsd.app.shopCar.entity.ShopCarDTO;
import com.xzsd.app.shopCar.entity.ShopCarInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCarDao {

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
