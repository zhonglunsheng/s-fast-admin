package com.lipop.backend.service.impl;

import com.google.common.collect.Maps;
import com.lipop.backend.config.datasource.DataSourceType;
import com.lipop.backend.config.datasource.annotation.DataSource;
import com.lipop.backend.entity.ExpandEntity;
import com.lipop.backend.mapper.ExplandMaper;
import com.lipop.backend.service.IExplandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-20 21:13
 */
@Service("explandService")
@DataSource(value = DataSourceType.SLAVE)
public class ExplandServiceImpl implements IExplandService {

    @Resource
    private ExplandMaper explandMaper;

    @Override
    public List<ExpandEntity> list() {
        String url = "333";
        String img = "222";
        String type = "111";

        ExpandEntity expandEntity = ExpandEntity.builder().type(type).build();
        Map<String, String> params = Maps.newConcurrentMap();
        params.put("img", img);
        return explandMaper.listFive(url, expandEntity, params);
    }
}
