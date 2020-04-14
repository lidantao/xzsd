package com.xzsd.pc.rotate.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图RotateDao接口
 */


import com.xzsd.pc.rotate.entity.RotateDTO;
import com.xzsd.pc.rotate.entity.RotateInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RotateDao {

    //检查轮播图是否存在
    int checkRotate(RotateInfo rotateInfo);

    //新增首页轮播图接口
    int addRotate(RotateInfo rotateInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：新增首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    List<RotateInfo> listRotateByPage(RotateInfo rotateInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    List<RotateDTO> listGoodsByPage(RotateDTO rotateDTO);


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询商品接口（新增轮播图用）,rotateDTO为传递多参使用实体类信息
     */
    int updateRotate(RotateDTO rotateDTO);


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：修改首页轮播图状态接口,rotateDTO为传递多参使用实体类信息
     */
    int deleteRotate(RotateDTO rotateDTO);

}
