package com.xzsd.pc.rotate.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：首页轮播图RotateDao接口
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.rotate.dao.RotateDao;
import com.xzsd.pc.rotate.entity.RotateDTO;
import com.xzsd.pc.rotate.entity.RotateInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class RotateService {

    //注入RotateDao接口
    @Resource
    private RotateDao rotateDao;


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //新增首页轮播图接口
    public Response addRotate(RotateInfo rotateInfo) {
        //查询此轮播图是否使用
        int count = rotateDao.checkRotate(rotateInfo);
        if (count > 0) {
            return Response.error("此轮播图或轮播图排序序号已存在，请勿重复添加！");
        } else {
            //设置创建者和修改者
            rotateInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            rotateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            //随机生成轮播图编号,返回数据:时间戳+3为随机数
            rotateInfo.setRotateCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            rotateInfo.setIsDelete("0");
            int flag = rotateDao.addRotate(rotateInfo);
            if (flag > 0) {
                return Response.success("新增首页轮播图成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增首页轮播图信息增加有错！");
            }
        }
    }

    //分页查询首页轮播图接口
    public Response listRotate(RotateInfo rotateInfo) {
        List<RotateInfo> rotateInfoList = rotateDao.listRotateByPage(rotateInfo);
        if (rotateInfoList.size() == 0) {
            return Response.error("未查询到首页轮播图列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(rotateInfoList));
        }
    }


    //查询商品接口（新增轮播图用）
    public Response listGoods(RotateDTO rotateDTO) {
        List<RotateDTO> rotateDTOList = rotateDao.listGoodsByPage(rotateDTO);
        if (rotateDTOList.size() == 0) {
            return Response.error("未查询到商品列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(rotateDTOList));
        }
    }


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //修改首页轮播图状态接口
    public Response updateRotate(RotateDTO rotateDTO) {
        //设置当前修改者编码
        rotateDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = rotateDao.updateRotate(rotateDTO);
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
