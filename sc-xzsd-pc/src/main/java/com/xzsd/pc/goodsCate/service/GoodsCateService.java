package com.xzsd.pc.goodsCate.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/12下午14：22分
 * 功能：商品分类Service信息
 */


import com.alibaba.fastjson.JSON;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsCate.dao.GoodsCateDao;
import com.xzsd.pc.goodsCate.entity.GoodsCateInfo;
import com.xzsd.pc.user.entity.UserDTO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.neusoft.core.page.PageUtils.getPageInfo;


@Service
public class GoodsCateService {

    //注入GoodsCateDao类
    @Resource
    private GoodsCateDao goodsCateDao;



    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：检查添加此商品分类名称是否存在，goodsCateInfo为商品分类实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addGoodsCate(GoodsCateInfo goodsCateInfo) {
        //检查添加此商品分类名称是否存在
        int count = goodsCateDao.checkGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.error("此商品分类已存在，请勿重复添加！");
        } else {
            //随机生成商品分类编号,返回数据:时间戳+3为随机数
            goodsCateInfo.setGoodsCateCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            goodsCateInfo.setIsDelete("0");
            //设置创建者和修改者
            goodsCateInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            int flag = goodsCateDao.addGoodsCate(goodsCateInfo);
            if (flag > 0) {
                return Response.success("新增商品分类成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增商品分类信息有误，请重新填写！");
            }
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类详情接口，goodsCateCode为热门商品编号
     */
    public Response findGoodsCate(String goodsCateCode) {
        GoodsCateInfo goodsCateInfo = goodsCateDao.findGoodsCate(goodsCateCode);
        if (goodsCateInfo == null) {
            return Response.error("未查询到相关商品分类信息！");
        } else {
            return Response.success("查询成功!", goodsCateInfo);
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类列表接口
     */
    public Response listGoodsCate() {
        List<GoodsCateInfo> list1 = goodsCateDao.firstlistGoodsCate();
        List<GoodsCateInfo> list2 = goodsCateDao.secondlistGoodsCate();
        List<List<GoodsCateInfo>> list = new ArrayList<>();
        for(GoodsCateInfo goodsCateInfo:list1){
            List<GoodsCateInfo> firstList = new ArrayList<>();
            firstList.add(goodsCateInfo);
            for(GoodsCateInfo goodsCateInfo1:list2){
                if(goodsCateInfo.getGoodsCateCode().equals(goodsCateInfo1.getCateParentCode())){
                    firstList.add(goodsCateInfo1);
                }
            }
            list.add(firstList);
        }
        if(list.size()==0){
            return Response.error("未查询到相关商品分类列表信息1");
        }else {
            return Response.success("查询成功!",list);
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：修改商品分类接口，goodsCateInfo商品分类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateGoodsCate(GoodsCateInfo goodsCateInfo) {
        //设置当前修改者编码
        goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = goodsCateDao.updateGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改商品分类操作有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：删除商品分类接口，goodsCateInfo为商品分类实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteGoodsCate(GoodsCateInfo goodsCateInfo) {
        goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = goodsCateDao.deleteGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除商品分类操作有误！");
        }
    }
}
