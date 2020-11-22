package com.lipop.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_blog_USER")
@ApiModel(value="UserEntity对象", description="")
public class UserEntity extends Model<UserEntity> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableField("ID")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
