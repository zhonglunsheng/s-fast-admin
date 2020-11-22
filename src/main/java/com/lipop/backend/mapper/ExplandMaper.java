package com.lipop.backend.mapper;

import com.lipop.backend.entity.ExpandEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-20 21:07
 */
public interface ExplandMaper {

    List<ExpandEntity> list();

    @Select("select * from t_blog_expland where url = '333'")
    @ResultMap("BaseResultMap")
    List<ExpandEntity> listTwo();

    @Select("select * from t_blog_expland where url = '333'")
    @ResultType(ExpandEntity.class)
    List<ExpandEntity> listThree();

    @Select("select * from t_blog_expland where url = '333'")
    List<ExpandEntity> listFour();

    @Select("select * from t_blog_expland where url = #{url} and type = #{entity.type} and img = #{params.img}")
    @ResultType(ExpandEntity.class)
    List<ExpandEntity> listFour(String url, ExpandEntity entity, @Param("params") Map<String, String> params);


    List<ExpandEntity> listFive(String url, ExpandEntity entity, @Param("params") Map<String, String> params);



}
