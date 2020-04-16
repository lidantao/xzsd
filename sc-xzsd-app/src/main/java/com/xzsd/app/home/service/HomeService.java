package com.xzsd.app.home.service;


/**
 * 作者：李丹涛
 * 时间：2020/04/14
 * 功能：首页轮播图service类、热门商品service类
 */


import com.alibaba.fastjson.JSON;
import com.xzsd.app.home.dao.HomeDao;
import com.xzsd.app.home.entity.HomeInfo;
import com.xzsd.app.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class HomeService {



    //注入HomeDao接口
    @Resource
    private HomeDao homeDao;

    /**
     * 轮播图状态
     * START:启用0、
     * STOP:禁用1
     */
    private static final String START = "0";
    private static final String STOP = "1";

    /**
     * 作者：李丹涛
     * 时间：2020/04/14
     * 功能：查询首页轮播图接口
     */
    public Response listRotate() {
        String rotateActive = START;
        List<HomeInfo> list = homeDao.listRotate(rotateActive);
        System.out.println(JSON.toJSONString(list));
        if (list.size() == 0) {
            return Response.error("暂未查到轮播图信息，检查是否有添加！");
        } else {
            return Response.success("查询成功！", list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    public Response listHotGoods(){
        List<HomeInfo> list = homeDao.listHotGoodsByPage();
        if (list.size() == 0) {
            return Response.error("暂未查到热门商品信息，检查是否有添加！");
        } else {
            return Response.success("查询成功！", getPageInfo(list));
        }
    }


}
