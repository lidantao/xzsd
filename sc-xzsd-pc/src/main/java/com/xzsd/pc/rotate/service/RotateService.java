package com.xzsd.pc.rotate.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图RotateDao接口
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.rotate.dao.RotateDao;
import com.xzsd.pc.rotate.entity.RotateDTO;
import com.xzsd.pc.rotate.entity.RotateInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class RotateService {

    //注入RotateDao接口
    @Resource
    private RotateDao rotateDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：轮播图状态
     * start：启用0、
     * stop：禁用1
     */
    private static final String START = "0";
    private static final String STOP = "1";


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：新增首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addRotate(RotateInfo rotateInfo) {
        //查询此轮图商品或轮播图排序是否存在
        int count = rotateDao.checkRotate(rotateInfo);
        if (count > 0) {
            return Response.error("此此轮图商品或轮播图排序已存在，请重新填写！");
        } else {
            //设置创建者和修改者
            rotateInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            rotateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            //随机生成轮播图编号,返回数据:时间戳+3为随机数
            rotateInfo.setRotateCode(StringUtil.getCommonCode(3));
            //设置轮播图状态，默认启用
            rotateInfo.setRotateActive(START);
            //删除标记：未删除0
            rotateInfo.setIsDelete("0");
            int flag = rotateDao.addRotate(rotateInfo);
            if (flag > 0) {
                return Response.success("新增首页轮播图成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增首页轮播图信息有误！");
            }
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询首页轮播图接口,rotateInfo为轮播图实体类信息
     */
    public Response listRotate(RotateInfo rotateInfo) {
        List<RotateInfo> rotateInfoList = rotateDao.listRotateByPage(rotateInfo);
        if (rotateInfoList.size() == 0) {
            return Response.error("未查询到首页轮播图列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(rotateInfoList));
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：分页查询商品接口（新增轮播图用）,rotateDTO为传递多参使用实体类信息
     */
    public Response listGoods(RotateDTO rotateDTO) {
        List<RotateDTO> rotateDTOList = rotateDao.listGoodsByPage(rotateDTO);
        if (rotateDTOList.size() == 0) {
            return Response.error("未查询到商品列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(rotateDTOList));
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/12凌晨00：17分
     * 功能：修改首页轮播图状态接口,rotateDTO为传递多参使用实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateRotate(String rotateCode,String version, String rotateActive) {
        List<String> rotateCodeList = Arrays.asList(rotateCode.split(","));
        List<String> versionList = Arrays.asList(version.split(","));
        //new一个RotateInfo用于传参
        RotateInfo rotateInfo = new RotateInfo();
        //设置当前修改者编码
        rotateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //轮播图修改成什么状态
        rotateInfo.setRotateActive(rotateActive);
        //new一个mapList给mybaties用
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < rotateCodeList.size(); i++) {
            Map map = new HashMap();
            map.put("rotateCode",rotateCodeList.get(i));
            map.put("version",versionList.get(i));
            mapList.add(map);
        }
        rotateInfo.setMapList(mapList);
        int count = rotateDao.updateRotate(rotateInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改首页轮播图状态操作有误！");
        }
    }


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //删除首页轮播图接口
    public Response deleteRotate(RotateDTO rotateDTO) {
        rotateDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = rotateDao.deleteRotate(rotateDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除首页轮播图操作有误！");
        }
    }


}
