package com.xzsd.pc.driver.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/14凌晨01：51分
 * 功能：司机管理dao接口
 */

import com.xzsd.pc.driver.entity.DriverDTO;
import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增司机信息接口
     * driverInfo：司机实体类信息
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：查询司机信息详情接口
     * driverCode：司机编号
     */
    DriverInfo findDriver(String driverCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：分页查询司机接口
     * driverInfo：司机实体类信息
     */
    List<DriverInfo> listDriverByPage(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改司机信息接口
     * driverInfo：司机实体类信息
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：删除司机信息接口
     * driverDTO：前端传多参数使用实体类
     */
    int deleteDriver(DriverDTO driverDTO);

}
