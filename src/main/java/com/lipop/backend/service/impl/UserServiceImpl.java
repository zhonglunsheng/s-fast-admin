package com.lipop.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lipop.backend.config.datasource.DataSourceType;
import com.lipop.backend.config.datasource.annotation.DataSource;
import com.lipop.backend.entity.UserEntity;
import com.lipop.backend.mapper.UserMapper;
import com.lipop.backend.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public boolean save(UserEntity entity) {
        return super.save(entity);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<UserEntity> list() {
        return super.list();
    }
}
