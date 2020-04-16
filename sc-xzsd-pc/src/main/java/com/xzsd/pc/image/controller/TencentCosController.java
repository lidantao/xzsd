package com.xzsd.pc.image.controller;


/**
 * 作者：李丹涛
 * 时间：2020/04/16中午10：32分
 * 功能：图片上传controller类
 */

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.image.service.TencentCosService;
import com.xzsd.pc.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/image")
public class TencentCosController {

    @Resource
    private TencentCosService tencentCosService;

    @PostMapping("uploadImage")
    public Response upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        try {
            return tencentCosService.upload(multipartFile);
        }catch (Exception e) {
            throw e;
        }
    }

}
