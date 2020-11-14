package com.lipop.backend.auth.token;

import com.lipop.backend.auth.AuthConstants;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhonglunsheng
 * @Description 前端保存jwt生成的token token含有用户账号和密码基本登录信息 缺点jwt是无状态的 不能删除token
 * 修改token信息 必须借助第三方mysql或redis保存状态
 * @create 2020-11-14 11:21
 */
@Component
public class TokenBasicService extends TokenAbstractService {
    /**
     * 令牌自定义标识
     */
    @Value("${token.header}")
    private String header;

    /**
     * 令牌秘钥
     */
    @Value("${token.secret}")
    private String secret;

    /**
     * 令牌有效期（默认30分钟）
     */
    @Value("${token.expireTime}")
    private int expireTime;


    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;


    @PostConstruct
    public void init() {
        super.init(MILLIS_MINUTE_TEN, secret, header);
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    @Override
    public TokenUser getTokenUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            return (TokenUser) claims.get(AuthConstants.LOGIN_USER_KEY);
        }
        return null;
    }

    /**
     * 设置用户身份信息
     */
    @Override
    public void setLoginUser(TokenUser loginUser) {

    }

    /**
     * 删除用户身份信息
     */
    @Override
    public void delLoginUser(String token) {

    }


}
