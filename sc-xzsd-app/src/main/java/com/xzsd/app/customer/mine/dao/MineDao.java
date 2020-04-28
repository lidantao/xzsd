package com.xzsd.app.customer.mine.dao;

import com.xzsd.app.customer.mine.entity.MineInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午14：12分
 * 功能：我的信息实体类（修改邀请码）
 */

@Mapper
public interface MineDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15分下午14：21分
     * 功能：检查修改得邀请码是否存在
     */
    int isExitInviteCode(MineInfo mineInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：13分
     * 功能：修改邀请码
     */
    int updateInviteCode(MineInfo mineInfo);

}
