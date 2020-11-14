package com.lipop.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog_tag")
public class TagEntity extends Model<TagEntity> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签排序
     */
    private Integer tagSort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
