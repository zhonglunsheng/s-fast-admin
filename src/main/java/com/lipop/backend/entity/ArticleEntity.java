package com.lipop.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 博客文章表
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog_article")
public class ArticleEntity extends Model<ArticleEntity> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 标签
     */
    private String tagId;

    /**
     * 分类
     */
    private String categoryId;

    /**
     * 文章内容 md格式
     */
    private String mdContent;

    /**
     * 微信编辑格式
     */
    private String wxContent;

    /**
     * md转html
     */
    private String htmlContent;

    /**
     * uv 阅读量
     */
    private Integer uvViews;

    /**
     * pv 阅读量
     */
    private Integer pvViews;

    /**
     * 文章访问密码
     */
    private String password;

    /**
     * 文章状态 0：显示  1：不显示  2：草稿  3：回收站
     */
    private String statusFlag;

    /**
     * 文章来源 0：原创  1：转载 2：翻译 3：爬虫
     */
    private String source;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
