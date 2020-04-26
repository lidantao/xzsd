package com.xzsd.app.manager.register.dao;

import com.xzsd.app.manager.register.entity.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作者：李丹涛
 * 时间：2020/04/16下午17：14分
 * 功能：注册Dao接口
 */

@Mapper
public interface RegisterDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：查询账号或手机是否存在，registerInfo用户信息
     */
    int checkUser(RegisterInfo registerInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16下午17：14分
     * 功能：新增用户
     * registerInfo：客户实体类信息
     */
    int addUser(RegisterInfo registerInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/16下午17：14分
     * 功能：注册接口，registerInfo注册用户信息实体类
     */
    int clientRegister(RegisterInfo registerInfo);


}
