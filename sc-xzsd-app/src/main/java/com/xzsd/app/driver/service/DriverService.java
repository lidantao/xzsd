package com.xzsd.app.driver.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/15下午15：24分
 * 功能：查询司机负责门店，店长的相关信息Service类
 */

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.utils.Response;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Security;
import java.util.List;

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
        DriverInfo driverInfo = driverDao.findDriverStore(userCode);
        if (driverInfo == null) {
            return Response.error("未查询到相关店长信息！");
        } else {
            String address = driverInfo.getProvinceName()
                    + driverInfo.getCityName()
                    + driverInfo.getAreaName()
                    + driverInfo.getAddress();
            driverInfo.setAddress(address);
            return Response.success("查询成功！", driverInfo);
        }
    }
}
