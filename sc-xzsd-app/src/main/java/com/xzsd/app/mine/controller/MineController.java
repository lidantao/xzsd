package com.xzsd.app.mine.controller;

import com.xzsd.app.mine.entity.MineInfo;
import com.xzsd.app.mine.service.MineService;
import com.xzsd.app.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：我的信息（客户）管理controller类
 */

@RestController
@RequestMapping("/mine")
@Validated
public class MineController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(MineController.class);

    //注入GoodsService类
    @Resource
    private MineService mineService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：13分
     * 功能：修改邀请码
     */
    @PostMapping("updateInviteCode")
    public Response updateInviteCode(MineInfo mineInfo){
        try {
            return mineService.updateInviteCode(mineInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改邀请码有误！");
        }
    }
}
