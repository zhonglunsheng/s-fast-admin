package com.lipop.backend.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-13 22:12
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private ExampleInterceptor exampleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(exampleInterceptor).addPathPatterns("/**");
    }
}
