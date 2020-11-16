package com.lipop.backend.service.impl;

import com.lipop.backend.entity.UserEntity;
import com.lipop.backend.mapper.UserMapper;
import com.lipop.backend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhonglunsheng
 * @since 2020-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

}
