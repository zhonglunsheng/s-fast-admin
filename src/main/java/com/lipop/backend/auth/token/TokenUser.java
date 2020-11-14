package com.lipop.backend.auth.token;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-14 11:22
 */
@Getter
@Setter
public class TokenUser {
    private String userName;
    private String password;
    private Long expireTime;
}
