package com.xzsd.pc.user.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/10
 * 功能：用户管理Service类
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserDTO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.PasswordUtils;
import com.xzsd.pc.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class UserService {

    //注入UserDao类
    @Resource
    private UserDao userDao;


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //新增用户，userInfo用户信息
    public Response addUser(UserInfo userInfo) {
        //查询账号或手机是否存在，userInfo用户信息
        int count = userDao.checkUser(userInfo);
        if (count > 0) {
            return Response.error("账号或手机号存在，请重新填写！");
        } else {
            //加密密码
            userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
            //随机生成用户编号,返回数据:时间戳+3为随机数
            userInfo.setUserCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            userInfo.setIsDelete("0");
            //设置创建者和修改者
            userInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            int flag = userDao.addUser(userInfo);
            if (flag > 0) {
                return Response.success("新增用户成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增用户有误！");
            }
        }
    }


    //查询用户详情，userCode用户编号
    public Response findUser(String userCode) {
        UserInfo userInfo = userDao.findUser(userCode);
        if (userInfo == null) {
            return Response.error("未查询到相关用户信息！");
        } else {
            return Response.success("查询成功!", userInfo);
        }
    }


    //查询用户分页列表信息，userInfo用户信息
    public Response listUser(UserInfo userInfo) {
        List<UserInfo> userInfoList = userDao.listUserByPage(userInfo);
        if (userInfoList.size() == 0) {
            return Response.error("未查询到相关用户列表信息！");
        } else {
            return Response.success("查询成功！", getPageInfo(userInfoList));
        }
    }


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //修改用户，userInfo用户信息
    public Response updateUser(UserInfo userInfo) {
        //设置当前修改者编码
        userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = userDao.updateUser(userInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改用户操作有误！");
        }
    }


    //添加事务
    @Transactional(rollbackFor = Exception.class)
    //删除用户，userDTO用户form传的参数
    public Response deleteUser(UserDTO userDTO) {
        userDTO.setLastUpdateUser(SecurityUtils.getCurrentUserId());
        int count = userDao.deleteUser(userDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除用户操作有误！");
        }
    }

}
