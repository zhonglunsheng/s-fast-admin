package com.lipop.backend.controller;

import com.lipop.backend.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-12 22:49
 */
@Api("swagger ui test")
@Log4j2
@RestController
public class IndexController {

    @ApiOperation("用户信息")
    @ApiImplicitParam(name = "userEntity", value = "获取用户信息", dataType = "UserEntity")
    @PostMapping("/list")
    public String hello(UserEntity user) {
        log.info(user);
        return "hello";
    }
}
