package com.lipop.backend.controller;


import com.lipop.backend.entity.UserEntity;
import com.lipop.backend.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-16
 */
@Controller
@Log4j2
@RequestMapping("/userEntity")
@Api
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    @ResponseBody
    @ApiOperation("新增用户")
    public Boolean addUser(UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping("/user")
    @ResponseBody
    @ApiOperation("获取用户信息")
    public List<UserEntity> getUser() {
        return userService.list();
    }
}

