package com.xzsd.pc.top.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/19凌晨01：49分
 * 功能：查询顶部栏信息dao接口
 */

import com.xzsd.pc.top.entity.TopInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface TopDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨01：49分
     * 功能：查询顶部栏信息dao接口
     */
    TopInfo getTop(@Param("userCode") String userCode);
}
