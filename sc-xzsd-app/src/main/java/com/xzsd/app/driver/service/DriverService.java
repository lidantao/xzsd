package com.xzsd.app.driver.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午15：24分
 * 功能：查询司机负责门店，店长的相关信息Service类
 */

@Service
public class DriverService {

    //注入DriverDao接口
    @Resource
    private DriverDao driverDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午15：09分
     * 功能：查询司机负责门店，店长的相关信息，
     */
    public Response findDriverStore() {
        String userCode = SecurityUtils.getCurrentUserId();
        List<DriverInfo> list = driverDao.findDriverStore(userCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关店长信息！");
        } else {
            for (DriverInfo driverInfo:list) {
                String address = driverInfo.getProvinceName()
                        + driverInfo.getCityName()
                        + driverInfo.getAreaName()
                        + driverInfo.getAddress();
                driverInfo.setAddress(address);
            }
            return Response.success("查询成功！",list);
        }
    }
}
