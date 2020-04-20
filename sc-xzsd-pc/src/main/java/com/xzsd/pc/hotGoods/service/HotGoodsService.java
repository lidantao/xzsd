package com.xzsd.pc.hotGoods.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品管理service类
 */

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoodsDTO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class HotGoodsService {

    //注入HotGoodsDao类
    @Resource
    private HotGoodsDao hotGoodsDao;



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：新增热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addHotGoods(HotGoodsInfo hotGoodsInfo){
        //检查添加此热门商品或排序是否存在
        int count = hotGoodsDao.checkHotGoods(hotGoodsInfo);
        if (count > 0) {
            return Response.error("此热门商品或排序已存在，请重新定义填写！");
        } else {
            //随机生成热门商品编号,返回数据:时间戳+3为随机数
            hotGoodsInfo.setHotGoodsCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            hotGoodsInfo.setIsDelete("0");
            //设置创建者和修改者
            hotGoodsInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            hotGoodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            int flag = hotGoodsDao.addHotGoods(hotGoodsInfo);
            if (flag > 0) {
                return Response.success("新增热门商品成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增热门商品信息有误，请重新填写！");
            }
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品详情接口,hotGoodsInfo是热门商品实体类信息
     */
    public Response findHotGoods(String hotGoodsCode){
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.findHotGoods(hotGoodsCode);
        if (hotGoodsInfo == null) {
            return Response.error("未查询到相关热门商品信息！");
        } else {
            return Response.success("查询成功!", hotGoodsInfo);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：分页查询热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    public Response listHotGoods(HotGoodsInfo hotGoodsInfo) {
        //查询需要展示的数量
        HotGoodsInfo hotGoodsInfo1 = hotGoodsDao.findHotGoodsShowNum();
        //查询热门商品信息
        List<HotGoodsInfo> hotGoodsInfoList = hotGoodsDao.listHotGoodsByPage(hotGoodsInfo);
        if (hotGoodsInfoList.size() == 0) {
            return Response.error("未查询到相关热门商品列表信息!");
        } else {
            //新的热门商品表（数量设置后）
            List<HotGoodsInfo> newHotGoodsInfoList = new ArrayList<>();
            //展示数量叠加
            for (int i = 0; i < hotGoodsInfo1.getHotGoodsShowNum(); i++) {
                if(i >= hotGoodsInfoList.size()){
                    break;
                }
                newHotGoodsInfoList.add(hotGoodsInfoList.get(i));
            }
            return Response.success("查询成功！", getPageInfo(newHotGoodsInfoList));
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateHotGoods(HotGoodsInfo hotGoodsInfo){
        //设置当前修改者编码
        hotGoodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改热门商品操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品展示数量接口
     */
    public Response findHotGoodsShowNum(){
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.findHotGoodsShowNum();
        return Response.success("查询热门商品展示数量成功！",hotGoodsInfo);
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品数量展示接口,hotGoodsInfo是热门商品实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo){
        //设置当前修改者编码
        hotGoodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = hotGoodsDao.updateHotGoodsShowNum(hotGoodsInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改热门商品展示数量操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：删除热门商品接口,hotGoodsDTO是前端传递多参数接收的实体类信息
     */
    public Response deleteHotGoods(HotGoodsDTO hotGoodsDTO){
        hotGoodsDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = hotGoodsDao.deleteHotGoods(hotGoodsDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除热门商品操作有误！");
        }
    }
}
