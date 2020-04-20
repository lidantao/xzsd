package com.xzsd.app.shopCar.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：37分
 * 功能：购物车Service类
 */

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.shopCar.dao.ShopCarDao;
import com.xzsd.app.shopCar.entity.ShopCarDTO;
import com.xzsd.app.shopCar.entity.ShopCarInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class ShopCarService {


    //注入ShopCarDao接口
    @Resource
    private ShopCarDao shopCarDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addShopCar(ShopCarInfo shopCarInfo){
        //查看购物车是否存在此商品,是则+1即可
        //设置创建者和修改者
        shopCarInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        shopCarInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int isExit = shopCarDao.checkShopCar(shopCarInfo);
        if (isExit > 0) {
            //存在了，则更新数量+1
            int update = shopCarDao.updateShopCarCount(shopCarInfo);
            if(update>0){
                return Response.success("加入购物车成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("加入购物车有误！");
            }
        } else {
            //随机生成商品编号,返回数据:时间戳+3为随机数
            shopCarInfo.setShopCarCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            shopCarInfo.setIsDelete("0");
            int count = shopCarDao.addShopCar(shopCarInfo);
            if (count > 0) {
                return Response.success("加入购物车成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("加入购物车有误！");
            }
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    public Response listShopCar(){
        List<ShopCarInfo> list = shopCarDao.listShopCarByPage();
        if (list != null) {
            return Response.success("查询购物车成功！", getPageInfo(list));
        } else {
            return Response.error("未查询购物车信息！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateShopCar(ShopCarInfo shopCarInfo){
        //设置当前修改者编码
        shopCarInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = shopCarDao.updateShopCar(shopCarInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改购物车操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteShopCar(ShopCarDTO shopCarDTO){
        shopCarDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int delete = shopCarDao.deleteShopCar(shopCarDTO);
        if (delete > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除购物车操作有误！");
        }
    }
}
