package com.xzsd.pc.store.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上23：14分
 * 功能：门店管理service类
 */

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreDTO;
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
public class StoreService {

    //注入StoreDao接口
    @Resource
    private StoreDao storeDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    public Response listArea(String parentCode) {
        List<AreaInfo> list = storeDao.listArea(parentCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关地区信息！");
        } else {
            return Response.success("查询成功！", list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：新增门店信息接口
     * storeInfo：门店实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addStore(StoreInfo storeInfo){
        //设置创建者和修改者
        storeInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        storeInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //随机生成门店编号,返回数据:时间戳+3为随机数
        storeInfo.setStoreCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        storeInfo.setIsDelete("0");
        //随机生成6位邀请码
        storeInfo.setInviteCode(new RandomCode().genRandomNum());
        int flag = storeDao.addStore(storeInfo);
        if (flag > 0) {
            return Response.success("新增门店成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增门店信息增加有错！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：33分
     * 功能：查询门店信息详情接口
     * storeCode：门店编号
     */
    public Response findStore(String storeCode) {
        StoreInfo storeInfo = storeDao.findStore(storeCode);
        if (storeInfo != null) {
            return Response.success("查询门店信息详情成功！", storeInfo);
        } else {
            return Response.error("未查询到相关门店信息");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：36分
     * 功能：分页查询门店信息
     * storeInfo：门店实体类信息
     */
    public Response listStore(StoreInfo storeInfo) {
        List<StoreInfo> list = storeDao.listStoreByPage(storeInfo);
        if (list.size() == 0) {
            return Response.error("未查询到相关门店信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(list));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：39分
     * 功能：修改门店信息接口
     * storeInfo：门店实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateStore(StoreInfo storeInfo) {
        //设置当前修改者编码
        storeInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = storeDao.updateStore(storeInfo);
        if (count > 0) {
            return Response.success("修改门店信息成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改门店信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：42分
     * 功能：删除门店信息接口
     * storeDTO：用于用户传递多参数使用的实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteStore(StoreDTO storeDTO){
        //设置当前修改者编码
        storeDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = storeDao.deleteStore(storeDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除门店信息操作有误！");
        }
    }
}
