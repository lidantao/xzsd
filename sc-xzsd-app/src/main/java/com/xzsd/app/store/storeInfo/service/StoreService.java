package com.xzsd.app.store.storeInfo.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.store.storeInfo.dao.StoreDao;
import com.xzsd.app.store.storeInfo.entity.StoreInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：门店下司机信息StoreService类
 */

@Service
public class StoreService {

    //注入StoreDao接口
    @Resource
    private StoreDao storeDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    public Response listManangerDriver() {
        //获取当前登录用户编号
        String userCode = SecurityUtils.getCurrentUserId();
        List<StoreInfo> list = storeDao.listManangerDriver(userCode);
        if (list.size() == 0) {
            return Response.error("未查询到司机相关信息！");
        } else {
            return Response.success("查询司机信息详情成功！", list);
        }
    }

}
