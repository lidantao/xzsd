package com.xzsd.pc.menu.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/16凌晨00：42分
 * 功能：菜单管理Service类
 */

@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查询全部菜单列表
     */
    public Response listMenu(){
        List<MenuInfo> list = menuDao.listMenu();
        if(list.size()==0){
            return Response.error("查询菜单信息有误！！");
        }else {
            return Response.success("查询菜单列表成功",list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：根据角色查询首页菜单
     * （角色0：管理员可查看全部菜单，角色1：店长可看客户、订单、门店、司机菜单）
     */
    public Response listMenuHome(String userRole){
        List<MenuInfo> list = menuDao.listMenuHome(userRole);
        if(list.size()==0){
            return Response.error("查询菜单信息有误！！");
        }else {
            return Response.success("查询菜单列表成功",list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：新增菜单
     */
    public Response addMenu(MenuInfo menuInfo){
        //设置创建者和修改者
        menuInfo.setCreateUser(SecurityUtils.getCurrentUserId());
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //随机生成商品编号,返回数据:时间戳+3为随机数
        menuInfo.setMenuCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        menuInfo.setIsDelete("0");
        int count = menuDao.addMenu(menuInfo);
        if (count > 0) {
            return Response.success("新增菜单信息成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增菜单有误，请重新填写！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查看菜单详情
     */
    public Response findMenu(String menuCode){
        MenuInfo menuInfo = menuDao.findMenu(menuCode);
        if(menuInfo!=null){
            return Response.success("查询成功！",menuInfo);
        }else {
            return Response.error("提供的菜单编号有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：修改菜单
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateMenu(MenuInfo menuInfo){
        //设置当前修改者编码
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = menuDao.updateMenu(menuInfo);
        if (count > 0) {
            return Response.success("修改菜单成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的菜单信息有误，请重新填写！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：删除菜单
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteMenu(MenuInfo menuInfo){
        //设置当前修改者编码
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = menuDao.deleteMenu(menuInfo);
        if (count > 0) {
            return Response.success("删除菜单成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的菜单编号有误，请重新填写！");
        }
    }
}
