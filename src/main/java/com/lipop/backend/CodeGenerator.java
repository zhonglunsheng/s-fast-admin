package com.lipop.backend;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-08-02 16:09
 */

public class CodeGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setOpen(false);
        // XML 二级缓存
        gc.setEnableCache(true);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor("zhonglunsheng");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        String dbUrl = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"t_blog_", "t_data_"});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 排除生成的表
        strategy.setExclude(new String[]{"t_blog_user"});
        mpg.setStrategy(strategy);
        strategy.setEntityLombokModel(true);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.lipop.backend");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}