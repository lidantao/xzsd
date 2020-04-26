package com.xzsd.app.manager.register.service;

import com.neusoft.util.StringUtil;
import com.xzsd.app.manager.register.dao.RegisterDao;
import com.xzsd.app.manager.register.entity.RegisterInfo;
import com.xzsd.app.utils.PasswordUtils;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/16下午17：14分
 * 功能：注册Service类
 */

@Service
public class RegisterService {


    //注入注册dao接口
    @Resource
    private RegisterDao registerDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/16下午17：14分
     * 功能：注册接口，registerInfo注册用户信息实体类
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response clientRegister(RegisterInfo registerInfo) {
        //查询账号或手机是否存在，userInfo用户信息
        int check = registerDao.checkUser(registerInfo);
        if (check > 0) {
            return Response.error("账号或手机号存在，请重新填写！");
        } else {
            //设置用户角色 客户为 3 字段
            registerInfo.setUserRole("3");
            //加密密码
            registerInfo.setUserPassword(PasswordUtils.generatePassword(registerInfo.getUserPassword()));
            //随机生成用户编号,返回数据:时间戳+3为随机数
            registerInfo.setUserCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            registerInfo.setIsDelete("0");
            //设置创建者和修改者
            registerInfo.setCreateUser(registerInfo.getUserCode());
            registerInfo.setLastUpdateUser(registerInfo.getUserCode());
            //新增到用户表
            int add1 = registerDao.addUser(registerInfo);
            //新增到客户表
            int add2 = registerDao.clientRegister(registerInfo);
            if (add1 > 0 && add2 > 0) {
                return Response.success("新增客户成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("提供的客户信息有误，请重新填写！");
            }
        }
    }


}
