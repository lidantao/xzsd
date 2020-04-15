package com.xzsd.pc.customer.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/12晚上23：45分
 * 功能：客户信息管理service类
 */


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;


@Service
public class CustomerService {


    //注入UserDao类
    @Resource
    private CustomerDao customerDao;

    /**
     * 用户角色（店长编号为1）
     */
    private static final String ROLE = "1";


    /**
     * 作者：李丹涛
     * 时间：2020/04/12晚上23：45分
     * 功能：查询用户分页列表信息，customerInfo是客户信息
     */
    public Response listCustomer(CustomerInfo customerInfo) {
        if(customerInfo.getUserRole()==ROLE){
            //角色为店长，只查询自己门店下的客户
            customerInfo.setUserCode(SecurityUtils.getCurrentUserId());
            List<CustomerInfo> list = customerDao.listCustomerStoreByPage(customerInfo);
            if (list.size() == 0) {
                return Response.error("未查询到相关客户列表信息！");
            } else {
                return Response.success("查询成功！", getPageInfo(list));
            }
        }else {
            //角色为管理员查全部客户
            List<CustomerInfo> list = customerDao.listCustomerByPage(customerInfo);
            if (list.size() == 0) {
                return Response.error("未查询到相关客户列表信息！");
            } else {
                return Response.success("查询成功！", getPageInfo(list));
            }
        }

    }

}
