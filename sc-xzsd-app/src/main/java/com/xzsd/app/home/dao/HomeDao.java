package com.xzsd.app.home.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/14
 * 功能：首页轮播图dao接口、热门商品dao接口
 */


import com.xzsd.app.home.entity.HomeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：查询首页轮播图接口
     */
    List<HomeInfo> listRotate(String rotateActive);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    List<HomeInfo> listHotGoodsByPage();

}
