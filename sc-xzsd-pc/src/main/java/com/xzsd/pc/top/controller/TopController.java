package com.xzsd.pc.top.controller;

import com.xzsd.pc.top.service.TopService;
import com.xzsd.pc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/12凌晨00：17分
 * 功能：查询顶部栏信息controller类
 */

@RestController
@RequestMapping("/top")
@Validated
public class TopController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(TopController.class);

    //注入service类
    @Resource
    private TopService topService;

    @PostMapping("getTop")
    public Response getTop(){
        try{
            Response response = topService.getTop();
            return response;
        }catch (Exception e){
            logger.error(e.toString());
            return Response.servers("查询顶部栏操作有误！");
        }
    }

}
