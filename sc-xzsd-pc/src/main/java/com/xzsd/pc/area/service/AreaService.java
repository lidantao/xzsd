package com.xzsd.pc.area.service;

import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上22：27分
 * 功能：查询省市区下拉框Service类
 */

@Service
public class AreaService {

    //注入AreaDao接口
    @Resource
    private AreaDao areaDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    public Response listArea(String parentCode) {
        List<AreaInfo> list = areaDao.listArea(parentCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关地区信息！");
        } else {
            return Response.success("查询成功！", list);
        }
    }
}
