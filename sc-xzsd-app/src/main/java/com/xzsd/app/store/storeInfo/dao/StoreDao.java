package com.xzsd.app.store.storeInfo.dao;

import com.xzsd.app.store.storeInfo.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：店长个人信息之查询司机信息管理Dao类
 */

@Mapper
public interface StoreDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    List<StoreInfo> listManangerDriver(String userCode);
}
