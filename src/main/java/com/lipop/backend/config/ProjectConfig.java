package com.lipop.backend.config;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-12 22:44
 */
@Component
@Data
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;


    @Setter
    @Getter
    @Component
    @ConfigurationProperties(
            prefix = "project.configuration.auth"
    )
    public static class Auth {
        private Boolean login;
        private Boolean security;
    }

}
