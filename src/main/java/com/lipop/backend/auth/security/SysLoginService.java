package com.lipop.backend.auth.security;

import com.lipop.backend.auth.token.TokenBasicService;
import com.lipop.backend.auth.token.TokenUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author ruoyi
 */
@Component
public class SysLoginService {

    @Autowired
    private TokenBasicService tokenBasicService;

    @Resource
    private AuthenticationManager authenticationManager;


    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        // 用户验证
        Authentication authentication = null;
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
        authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        TokenUser loginUser = (TokenUser) authentication.getPrincipal();
        // 生成token
        return tokenBasicService.createToken(loginUser);
    }
}
