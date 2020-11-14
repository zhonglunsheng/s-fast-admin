package com.lipop.backend.service.impl;

import com.lipop.backend.entity.CategoryEntity;
import com.lipop.backend.mapper.CategoryMapper;
import com.lipop.backend.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements ICategoryService {

}
