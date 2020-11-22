package com.lipop.backend.controller;

import com.lipop.backend.entity.ExpandEntity;
import com.lipop.backend.service.IExplandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-20 21:14
 */
@RestController
@RequestMapping("/expland")
@Api("mybatis基本使用")
public class ExplandController {


    @Autowired
    private IExplandService explandService;

    @ApiOperation("列表信息")
    @PostMapping("/list")
    public List<ExpandEntity> list() {
        return explandService.list();
    }


}
