package com.xzsd.pc.customer.controller;


import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    //注入Userservice类
    @Resource
    private CustomerService customerService;

    //查询用户分页列表信息，customerInfo客户信息实体类
    @PostMapping("listCustomer")
    public Response listCustomer(CustomerInfo customerInfo) {
        try {
            return customerService.listCustomer(customerInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询客户分页列表信息操作有误！");
        }
    }
}
