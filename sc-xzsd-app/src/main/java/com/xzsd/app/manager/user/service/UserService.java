package com.xzsd.app.manager.user.service;

import com.alibaba.fastjson.JSON;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.manager.user.dao.UserDao;
import com.xzsd.app.manager.user.entity.UserInfo;
import com.xzsd.app.utils.PasswordUtils;
import com.xzsd.app.utils.Response;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/19凌晨02：41分
 * 功能：查询个人信息service类
 */

@Service
public class UserService {

    //注入查询用户dao类
    @Resource
    private UserDao userDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19早上10：12分
     * 功能：角色
     */
    //店长
    private static final String STORE = "1";
    //客户
    private static final String CUSTOMER = "3";
    //司机
    private static final String DRIVER = "4";

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：41分
     * 功能：查询个人信息
     */
    public Response findUser(){
        String userCode = SecurityUtils.getCurrentUserId();
        System.out.println("\n********************\n");
        System.out.println("用户编号："+ userCode);
        System.out.println("\n********************\n");
        //先找用户表基本所需信息
        UserInfo userInfo = userDao.findUser(userCode);
        System.out.println("\n********************\n");
        System.out.println("用户表基本信息："+JSON.toJSONString(userInfo));
        System.out.println("\n********************\n");
        //查询是什么角色
        System.out.println("\n********************\n");
        String role = userDao.checkRole(userCode);
        System.out.println("用户角色："+role);
        System.out.println("\n********************\n");
        UserInfo userInfo1 = new UserInfo();
        //店长
        if(role.equals(STORE)){
            System.out.println("\n********************\n");
            System.out.println("是个店长！");
            System.out.println("\n********************\n");
            userInfo1 = userDao.findStore(userCode);
            String address = userInfo1.getProvinceName()+userInfo1.getCityName()+userInfo1.getCityName()+userInfo1.getAddress();
            userInfo1.setAddress(address);
            System.out.println("\n********************\n");
            System.out.println("店长信息："+JSON.toJSONString(userInfo1));
            System.out.println("\n********************\n");
        }
        //客户
        if(role.equals(CUSTOMER)){
            userInfo1 = userDao.findCustomer(userCode);
            String address = userInfo1.getProvinceName()+userInfo1.getCityName()+userInfo1.getCityName()+userInfo1.getAddress();
            userInfo1.setAddress(address);
        }
        //司机
        if(role.equals(DRIVER)){
            userInfo1 = userDao.findDriver(userCode);
        }
        //用户基本信息塞进同一实体类整合
        userInfo1.setUserName(userInfo.getUserName());
        userInfo1.setUserImagePath(userInfo.getUserImagePath());
        userInfo1.setRole(userInfo.getRole());
        if(userInfo1==null){
            return Response.error("未查询相关信息，请重新查找！");
        }else {
            return Response.success("查询成功！",userInfo1);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：43分
     * 功能：修改密码
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateUserPassword(UserInfo userInfo){
        String userCode = SecurityUtils.getCurrentUserId();
        //String userCode = "20200418160238835042";
        userInfo.setUserCode(userCode);
        //设置当前修改者编码
        userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        //密码校验过程
        //获取旧的存在数据库的司机信息
        String userPassword = userDao.findUserPassword(userCode);
        //获取原密码（上一次修改或添加的已加密的原密码）
        String oldPassord = userPassword;
        //获取原密码（本次修改密码传的原密码是未加密的哦）
        String newPassword = userInfo.getUserPassword();
        //比较密码是否相同
        Boolean isEquals = new BCryptPasswordEncoder().matches(newPassword, oldPassord);
        if (isEquals) {
            userInfo.setUserNewPassword(PasswordUtils.generatePassword(userInfo.getUserNewPassword()));
            int update = userDao.updateUserPassword(userInfo);
            if (update > 0) {
                return Response.success("修改密码成功！");
            } else {
                //修改失败,事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("修改密码有误！");
            }
        } else {
            return Response.error("原密码错误，请重新输入！");
        }
    }
}
