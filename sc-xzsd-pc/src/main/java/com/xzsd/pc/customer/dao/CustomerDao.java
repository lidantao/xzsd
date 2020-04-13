package com.xzsd.pc.customer.dao;


/**
 * 作者：李丹涛
 * 时间：2020/04/12晚上23：45分
 * 功能：客户信息管理dao接口
 */

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {

    //分页查询客户信息接口
    List<CustomerInfo> listCustomerByPage(CustomerInfo customerInfo);

}
