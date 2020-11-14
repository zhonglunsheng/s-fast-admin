package com.lipop.backend.auth.token;

import com.lipop.backend.auth.AuthConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * token验证处理基类
 *
 * @author ruoyi
 */
public abstract class TokenAbstractService {

    private Long refreshTokenTime;

    private String secret;

    private String header;

    public void init(Long refreshTokenTime, String secret, String header) {
        this.refreshTokenTime = refreshTokenTime;
        this.secret = secret;
        this.header = header;
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public abstract TokenUser getTokenUser(HttpServletRequest request);

    /**
     * 设置用户身份信息
     */
    public abstract void setLoginUser(TokenUser loginUser);

    /**
     * 删除用户身份信息
     */
    public abstract void delLoginUser(String token);

    /**
     * 创建令牌
     *
     * @param tokenUser 用户信息
     * @return 令牌
     */
    public String createToken(TokenUser tokenUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(AuthConstants.LOGIN_USER_KEY, tokenUser);
        return createToken(claims);
    }

    /**
     * 验证令牌有效期，相差不足20分钟，重新生成一个token
     *
     * @param tokenUser
     * @return 令牌
     */
    public void verifyToken(HttpServletResponse response, TokenUser tokenUser) {
        long expireTime = tokenUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= refreshTokenTime) {
            // 重新生成一个token
            response.addHeader(header, createToken(tokenUser));
        }
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(AuthConstants.TOKEN_PREFIX)) {
            token = token.replace(AuthConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

}
