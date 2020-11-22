package com.lipop.backend.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-20 21:06
 */
@Data
@Builder
public class ExplandEntity {

    private Integer id;
    private String url;
    private String type;
    private String content;
    private String img;

}
