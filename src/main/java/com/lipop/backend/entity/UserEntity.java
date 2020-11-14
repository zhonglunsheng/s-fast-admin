package com.lipop.backend.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-12 22:59
 */
@Data
@ApiModel(value = "UserEntity", description = "用户实体")
public class UserEntity {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户手机")
    private String mobile;
}
