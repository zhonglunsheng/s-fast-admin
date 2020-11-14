package com.lipop.backend.service.impl;

import com.lipop.backend.entity.ArticleEntity;
import com.lipop.backend.mapper.ArticleMapper;
import com.lipop.backend.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客文章表 服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-12
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements IArticleService {

}
