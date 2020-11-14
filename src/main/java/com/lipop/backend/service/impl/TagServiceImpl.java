package com.lipop.backend.service.impl;

import com.lipop.backend.entity.TagEntity;
import com.lipop.backend.mapper.TagMapper;
import com.lipop.backend.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, TagEntity> implements ITagService {

}
