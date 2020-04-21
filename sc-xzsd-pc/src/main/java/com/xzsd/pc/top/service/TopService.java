package com.xzsd.pc.top.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.top.dao.TopDao;
import com.xzsd.pc.top.entity.TopInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/19凌晨01：49分
 * 功能：查询顶部栏信息service类
 */

@Service
public class TopService {

    //注入dao接口
    @Resource
    private TopDao topDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨01：49分
     * 功能：查询顶部栏信息service类
     */
    public Response getTop(){
        String userCode = SecurityUtils.getCurrentUserId();
        TopInfo topInfo = topDao.getTop(userCode);
        if(topInfo==null){
            return Response.error("未查询到相关顶部栏信息！");
        }else {
            return Response.success("查询成功！",topInfo);
        }
    }
}
