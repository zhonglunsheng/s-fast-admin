package com.lipop.backend.auth.token;

import com.lipop.backend.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器 验证token有效性
 *
 * @author ruoyi
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ProjectConfig.Auth authConfig;

    private ProjectConfig config;

    @Autowired
    private TokenBasicService tokenBasicService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // 判断是否启动jwt登录
        if (authConfig.getLogin()) {
            // todo 处理登录逻辑 请求时验证token
            TokenUser tokenUser = tokenBasicService.getTokenUser(request);
            if (tokenUser != null) {
                // 登录校验
                // 进行时间失效重置
                tokenBasicService.verifyToken(response, tokenUser);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(tokenUser, null, tokenUser.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            chain.doFilter(request, response);
        } else {
            // 继续执行
            chain.doFilter(request, response);
        }
    }
}
