package com.lipop.backend.auth.security;


import com.lipop.backend.auth.token.TokenUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 *
 * @author ruoyi
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 用户名唯一 从数据库获取用户信息进行判断
        log.info("=============用户登录验证 {}============", username);
        return createLoginUser();
    }

    public UserDetails createLoginUser() {
        return new TokenUser();
    }
}
