package com.xzsd.pc.area.controller;

import com.xzsd.pc.area.service.AreaService;
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
 * 时间：2020/04/16下午17：00分
 * 功能：省市区下拉框查询Controller类
 */

@RestController
@RequestMapping("/area")
@Validated
public class AreaController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AreaController.class);

    //注入AreaService类
    @Resource
    private AreaService areaService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    @PostMapping("listArea")
    public Response listArea(String parentCode) {
        try {
            return areaService.listArea(parentCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询省市区操作有误！");
        }
    }

}
