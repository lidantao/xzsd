package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午15：07分
 * 功能：查询司机负责门店，门店得相关信息
 */

@Mapper
public interface DriverDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午15：09分
     * 功能：查询司机负责门店，店长的相关信息，
     */
    List<DriverInfo> findDriverStore(String userCode);
}
