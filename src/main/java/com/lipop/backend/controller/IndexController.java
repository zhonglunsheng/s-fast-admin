package com.lipop.backend.controller;

import com.lipop.backend.config.ProjectConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-12 22:49
 */
@Log4j2
@RestController
public class IndexController {

    @Autowired
    ProjectConfig.Auth auth;

    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }
}
