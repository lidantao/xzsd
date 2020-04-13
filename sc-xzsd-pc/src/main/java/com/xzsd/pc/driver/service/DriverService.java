package com.xzsd.pc.driver.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/14凌晨01：51分
 * 功能：司机管理Service类
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDTO;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.utils.RandomCode;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class DriverService {

    //注入DriverDao接口
    @Resource
    private DriverDao driverDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增司机信息接口
     * driverInfo：司机实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addDriver(DriverInfo driverInfo){
        //设置创建者和修改者
        driverInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        driverInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //随机司机编号,返回数据:时间戳+3为随机数
        driverInfo.setUserCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        driverInfo.setIsDelete("0");
        int flag = driverDao.addDriver(driverInfo);
        if (flag > 0) {
            return Response.success("新增司机信息成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增司机信息有错！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：查询司机信息详情接口
     * driverCode：司机编号
     */
    public Response findDriver(String driverCode){
        DriverInfo driverInfo = driverDao.findDriver(driverCode);
        if (driverInfo != null) {
            return Response.success("查询司机信息详情成功！", driverInfo);
        } else {
            return Response.error("未查询到相关司机信息");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：分页查询司机接口
     * driverInfo：司机实体类信息
     */
    public Response listDriver(DriverInfo driverInfo){
        List<DriverInfo> list = driverDao.listDriverByPage(driverInfo);
        if (list.size() == 0) {
            return Response.error("未查询到相关司机信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(list));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改司机信息接口
     * driverInfo：司机实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateDriver(DriverInfo driverInfo){
        //设置当前修改者编码
        driverInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = driverDao.updateDriver(driverInfo);
        if (count > 0) {
            return Response.success("修改司机信息成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改司机信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：删除司机信息接口
     * driverDTO：前端传多参数使用实体类
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteDriver(DriverDTO driverDTO){
        //设置当前修改者编码
        driverDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = driverDao.deleteDriver(driverDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除司机信息操作有误！");
        }
    }
}
