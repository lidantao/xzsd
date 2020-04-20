package com.xzsd.app.mine.service;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午14：15分
 * 功能：我的信息管理Service类
 */

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.mine.dao.MineDao;
import com.xzsd.app.mine.entity.MineInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;


@Service
public class MineService {

    //注入MineDao接口
    @Resource
    private MineDao mineDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：13分
     * 功能：修改邀请码
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateInviteCode(MineInfo mineInfo) {
        int isExit = mineDao.isExitInviteCode(mineInfo);
        if (isExit > 0) {
            //设置当前修改者编码
            mineInfo.setUserCode(SecurityUtils.getCurrentUserId());
            mineInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            int count = mineDao.updateInviteCode(mineInfo);
            if (count > 0) {
                return Response.success("修改成功！");
            } else {
                //修改失败,事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("修改邀请码有误！");
            }
        } else {
            return Response.error("此邀请码不存在，请重新输入");
        }
    }
}
